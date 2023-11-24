package auca.com.crudd.controller;

import auca.com.crudd.domain.*;
import auca.com.crudd.repository.AcademicUnitRepository;
import auca.com.crudd.repository.SemesterRepository;
import auca.com.crudd.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/course",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private AcademicUnitRepository academicUnitRepository;
    @Autowired
    private SemesterRepository semesterRepository;

    @PostMapping(value = "/saveCourse")
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        if (course != null){
            String message = courseService.saveCourse(course);
            if(message!= null){
                return new ResponseEntity<>("Course saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getCourses")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> courses = courseService.GetAllCourse();
        if (courses != null && !courses.isEmpty()) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //    @GetMapping(value = "/GetCourse/{id}")
//    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
//        Course course = courseService.FindCourse(id);
//        if (course != null ) {
//            return new ResponseEntity<>(course, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping(value = "/DeleteCourse/{id}")
    public ResponseEntity<?> removeCourse(@PathVariable Long id){

        String message = courseService.deleteCourse(id);
        if(message!= null){
            return new ResponseEntity<>("Course deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
    @PutMapping(value = "/UpdateCourse/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course){

        String message = courseService.UpdateCourse(id, course);
        if(message!= null){
            return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }

    @GetMapping(value = "/getCoursesPerUnitAndSemester/{department_id}/{semester_id}")
    public ResponseEntity<?> getCoursesPerUnitAndSemester(@PathVariable Long department_id, @PathVariable Long semester_id) {

        Semester sem = semesterRepository.findById(semester_id).orElse(null);
        AcademicUnit dep = academicUnitRepository.findById(department_id).orElse(null);
        List<Course> Courses = courseService.getCoursesPerUnitAndSemester(dep,sem);
        if (Courses != null && !Courses.isEmpty()) {
            return new ResponseEntity<>(Courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
