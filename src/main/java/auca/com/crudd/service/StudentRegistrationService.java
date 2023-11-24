package auca.com.crudd.service;

import auca.com.crudd.domain.AcademicUnit;
import auca.com.crudd.domain.Semester;
import auca.com.crudd.domain.StudentRegistration;
import auca.com.crudd.repository.SemesterRepository;
import auca.com.crudd.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRegistrationService {
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    public String saveStudentRegistration(StudentRegistration studentRegistration){
        if (studentRegistration != null){
            //   StudentRegistration studentRegistration1 = studentRegistrationRepository.findById(studentRegistration.getStudentRegistration_id());
            studentRegistrationRepository.save(studentRegistration);
            return "StudentRegistration created successfully";
        }else{
            return null;
        }
    }

    public List<StudentRegistration> GetAllStudentRegistration(){
        return studentRegistrationRepository.findAll();

    }
    public String deleteStudentRegistration(Long id){
        if (id != null){
            studentRegistrationRepository.deleteById(id);
            return "StudentRegistration deleted successfully";
        }else{
            return null;
        }
    }
//    public String UpdateStudentRegistration(Long id, StudentRegistration studentRegistration){
//        if (id != null) {
//            StudentRegistration studentRegistrationFound = studentRegistrationRepository.findById(id).get();
//            studentRegistrationFound.setStudent(studentRegistration.getName());
//            studentRegistrationFound.setStartDate(studentRegistration.getStartDate());
//            studentRegistrationFound.setEndDate(studentRegistration.getEndDate());
//            studentRegistrationRepository.save(studentRegistrationFound);
//            return "studentRegistration updated successfully";
//        }
//        else{
//            return null;
//        }
//    }

    public List<StudentRegistration> getStudentsBySemester(Semester semester) {

        return studentRegistrationRepository.findBySemester(semester);
    }
//    public List<StudentRegistration> getStudentsByDepartmentAndSemester(AcademicUnit department, Semester semester) {
//        return studentRegistrationRepository.findByDepartmentAndSemester(department, semester);
//    }

    public List<StudentRegistration> getStudentsByDepartmentAndSemester(AcademicUnit academicUnit, Semester semester) {

        return studentRegistrationRepository.findByAcademicUnitAndSemester( academicUnit, semester);
    }

}
