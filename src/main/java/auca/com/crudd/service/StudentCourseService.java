package auca.com.crudd.service;

import auca.com.crudd.domain.*;
import auca.com.crudd.repository.StudentCourseRepository;
import auca.com.crudd.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;


    public String saveStudentCourse(StudentCourse studentCourse){
        if (studentCourse != null){
            //   StudentCourse studentCourse1 = studentCourseRepository.findById(studentCourse.getStudentCourse_id());
            studentCourseRepository.save(studentCourse);
            return "StudentCourse created successfully";
        }else{
            return null;
        }
    }

    public List<StudentCourse> GetAllStudentCourse(){
        return studentCourseRepository.findAll();

    }
    public String deleteStudentCourse(Long id){
        if (id != null){
            studentCourseRepository.deleteById(id);
            return "StudentCourse deleted successfully";
        }else{
            return null;
        }
    }
//    public String UpdateStudentCourse(Long id, StudentCourse studentCourse){
//        if (id != null) {
//            StudentCourse studentCourseFound = studentCourseRepository.findById(id).get();
//            studentCourseFound.setName(studentCourse.getName());
//            studentCourseFound.setStartDate(studentCourse.getStartDate());
//            studentCourseFound.setEndDate(studentCourse.getEndDate());
//            studentCourseRepository.save(studentCourseFound);
//            return "studentCourse updated successfully";
//        }
//        else{
//            return null;
//        }
//    }

    public List<StudentCourse> getAllCoursesPerStudent(StudentRegistration studentRegistration) {

        return studentCourseRepository.findCoursesByStudentRegistration(studentRegistration);
    }

    public List<StudentCourse> getStudentByCourseAndSemester(Course course, Semester semester) {
        List<StudentRegistration> students = studentRegistrationRepository.findBySemester(semester);
        List<StudentCourse> studentsFound = new ArrayList<>();
        for (StudentRegistration student : students) {
            List<StudentCourse> courses = studentCourseRepository.findByCourseAndStudentRegistration(course, student);
            studentsFound.addAll(courses);
        }
        return studentsFound;
    }
}
