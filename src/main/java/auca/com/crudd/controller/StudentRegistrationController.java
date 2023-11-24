package auca.com.crudd.controller;

import auca.com.crudd.domain.AcademicUnit;
import auca.com.crudd.domain.Semester;
import auca.com.crudd.domain.StudentRegistration;
import auca.com.crudd.repository.AcademicUnitRepository;
import auca.com.crudd.repository.SemesterRepository;
import auca.com.crudd.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/studentRegistration",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentRegistrationController {
    @Autowired
    private StudentRegistrationService studentRegistrationService;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private AcademicUnitRepository academicUnitRepository;
    @PostMapping(value = "/saveStudentRegistration")
    public ResponseEntity<?> createStudentRegistration(@RequestBody StudentRegistration studentRegistration){
        if (studentRegistration != null){
            String message = studentRegistrationService.saveStudentRegistration(studentRegistration);
            if(message!= null){
                return new ResponseEntity<>("StudentRegistration saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getStudentRegistrations")
    public ResponseEntity<List<StudentRegistration>> getStudentRegistrations() {
        List<StudentRegistration> studentRegistrations = studentRegistrationService.GetAllStudentRegistration();
        if (studentRegistrations != null && !studentRegistrations.isEmpty()) {
            return new ResponseEntity<>(studentRegistrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //    @GetMapping(value = "/GetStudentRegistration/{id}")
//    public ResponseEntity<StudentRegistration> getStudentRegistration(@PathVariable Long id) {
//        StudentRegistration studentRegistration = studentRegistrationService.FindStudentRegistration(id);
//        if (studentRegistration != null ) {
//            return new ResponseEntity<>(studentRegistration, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping(value = "/DeleteStudentRegistration/{id}")
    public ResponseEntity<?> removeStudentRegistration(@PathVariable Long id){

        String message = studentRegistrationService.deleteStudentRegistration(id);
        if(message!= null){
            return new ResponseEntity<>("StudentRegistration deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
//    @PutMapping(value = "/UpdateStudentRegistration/{id}")
//    public ResponseEntity<?> updateStudentRegistration(@PathVariable Long id, @RequestBody StudentRegistration studentRegistration){
//
//        String message = studentRegistrationService.UpdateStudentRegistration(id, studentRegistration);
//        if(message!= null){
//            return new ResponseEntity<>("StudentRegistration updated successfully", HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
//        }
//
//
//
//    }

    @GetMapping(value = "/getStudentsbySemester/{semester_id}")
    public ResponseEntity<List<StudentRegistration>> getStudentsBySemester(@PathVariable Long semester_id) {
        Semester sem = semesterRepository.findById(semester_id).orElse(null);

        List<StudentRegistration> studentsPerSemester = studentRegistrationService.getStudentsBySemester(sem);
        if (studentsPerSemester != null && !studentsPerSemester.isEmpty()) {
            return new ResponseEntity<>(studentsPerSemester, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getStudentsbyDepartmentAndSemester/{department_id}/{semester_id}")
    public ResponseEntity<List<StudentRegistration>> getStudentsByDepartmentAndSemester(@PathVariable Long department_id, @PathVariable Long semester_id) {
        Semester sem = semesterRepository.findById(semester_id).orElse(null);
        AcademicUnit dep = academicUnitRepository.findById(department_id).orElse(null);

        List<StudentRegistration> studentsPerDepAndSem = studentRegistrationService.getStudentsByDepartmentAndSemester(dep,sem);
        if (studentsPerDepAndSem != null && !studentsPerDepAndSem.isEmpty()) {
            return new ResponseEntity<>(studentsPerDepAndSem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
