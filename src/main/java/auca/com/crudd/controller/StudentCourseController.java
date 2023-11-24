package auca.com.crudd.controller;

import auca.com.crudd.domain.Course;
import auca.com.crudd.domain.Semester;
import auca.com.crudd.domain.StudentCourse;
import auca.com.crudd.domain.StudentRegistration;
import auca.com.crudd.repository.CourseRepository;
import auca.com.crudd.repository.SemesterRepository;
import auca.com.crudd.repository.StudentRegistrationRepository;
import auca.com.crudd.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/studentCourse",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    @PostMapping(value = "/saveStudentCourse")
    public ResponseEntity<?> createStudentCourse(@RequestBody StudentCourse studentCourse){
        if (studentCourse != null){
            String message = studentCourseService.saveStudentCourse(studentCourse);
            if(message!= null){
                return new ResponseEntity<>("StudentCourse saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getStudentCourses")
    public ResponseEntity<List<StudentCourse>> getStudentCourses() {
        List<StudentCourse> studentCourses = studentCourseService.GetAllStudentCourse();
        if (studentCourses != null && !studentCourses.isEmpty()) {
            return new ResponseEntity<>(studentCourses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //    @GetMapping(value = "/GetStudentCourse/{id}")
//    public ResponseEntity<StudentCourse> getStudentCourse(@PathVariable Long id) {
//        StudentCourse studentCourse = studentCourseService.FindStudentCourse(id);
//        if (studentCourse != null ) {
//            return new ResponseEntity<>(studentCourse, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping(value = "/DeleteStudentCourse/{id}")
    public ResponseEntity<?> removeStudentCourse(@PathVariable Long id){

        String message = studentCourseService.deleteStudentCourse(id);
        if(message!= null){
            return new ResponseEntity<>("StudentCourse deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
//    @PutMapping(value = "/UpdateStudentCourse/{id}")
//    public ResponseEntity<?> updateStudentCourse(@PathVariable Long id, @RequestBody StudentCourse studentCourse){
//
//        String message = studentCourseService.UpdateStudentCourse(id, studentCourse);
//        if(message!= null){
//            return new ResponseEntity<>("StudentCourse updated successfully", HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
//        }
//
//
//
//    }

    @GetMapping(value = "/getCoursesPerStudent/{studentReg_id}")
    public ResponseEntity<List<StudentCourse>> getStudentCourses(@PathVariable Long studentReg_id) {

        StudentRegistration studentRegistration = studentRegistrationRepository.findById(studentReg_id).orElse(null);
        List<StudentCourse> studentCourses = studentCourseService.getAllCoursesPerStudent(studentRegistration);
        if (studentCourses != null && !studentCourses.isEmpty()) {
            return new ResponseEntity<>(studentCourses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getStudentsPerCourseAndSemester/{course_id}/{semester_id}")
    public ResponseEntity<List<StudentCourse>> getStudentPerCoursesAndSemester(@PathVariable Long course_id, @PathVariable Long semester_id) {

        Course course = courseRepository.findById(course_id).orElse(null);
        Semester sem = semesterRepository.findById(semester_id).orElse(null);
        List<StudentCourse> studentCourses = studentCourseService.getStudentByCourseAndSemester(course,sem);
        if (studentCourses != null && !studentCourses.isEmpty()) {
            return new ResponseEntity<>(studentCourses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
