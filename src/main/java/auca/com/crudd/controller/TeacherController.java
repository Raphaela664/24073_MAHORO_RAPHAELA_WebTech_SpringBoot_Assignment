package auca.com.crudd.controller;

import auca.com.crudd.domain.Teacher;
import auca.com.crudd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(
        value = "/teacher",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping(value = "/saveTeacher")
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher){
        if (teacher != null){
            String message = teacherService.saveTeacher(teacher);
            if(message!= null){
                return new ResponseEntity<>("Teacher saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getTeachers")
    public ResponseEntity<List<Teacher>> getTeachers() {
        List<Teacher> teachers = teacherService.GetAllTeachers();
        if (teachers != null && !teachers.isEmpty()) {
            return new ResponseEntity<>(teachers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/GetTeacher/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.FindTeacher(id);
        if (teacher != null ) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/DeleteTeacher/{id}")
    public ResponseEntity<?> removeTeacher(@PathVariable Long id){

        String message = teacherService.deleteTeacher(id);
        if(message!= null){
            return new ResponseEntity<>("Teacher deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
    @PutMapping(value = "/UpdateTeacher/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){

        String message = teacherService.UpdateTeacher(id, teacher);
        if(message!= null){
            return new ResponseEntity<>("Teacher updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
}
