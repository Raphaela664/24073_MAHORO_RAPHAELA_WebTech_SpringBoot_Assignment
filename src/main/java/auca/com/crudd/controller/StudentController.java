package auca.com.crudd.controller;

import auca.com.crudd.domain.Student;
import auca.com.crudd.service.StudentService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping(
        value = "/student",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping(value = "/saveStudent")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        if (student != null){
            String message = studentService.saveStudent(student);
            if(message!= null){
                return new ResponseEntity<>("Student saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getStudents")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.GetAllStudents();
        if (students != null && !students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/GetStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
         Student student = studentService.FindStudent(id);
        if (student != null ) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/DeleteStudent/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id){

            String message = studentService.deleteStudent(id);
            if(message!= null){
                return new ResponseEntity<>("Student deleted", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }



    }
    @PutMapping(value = "/UpdateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){

        String message = studentService.UpdateStudent(id, student);
        if(message!= null){
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
}
