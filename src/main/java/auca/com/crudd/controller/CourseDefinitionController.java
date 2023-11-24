package auca.com.crudd.controller;

import auca.com.crudd.domain.CourseDefinition;
import auca.com.crudd.service.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/courseDefinition",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class CourseDefinitionController {
    @Autowired
    private CourseDefinitionService courseDefinitionService;
    @PostMapping(value = "/saveCourseDefinition")
    public ResponseEntity<?> createCourseDefinition(@RequestBody CourseDefinition courseDefinition){
        if (courseDefinition != null){
            String message = courseDefinitionService.saveCourseDefinition(courseDefinition);
            if(message!= null){
                return new ResponseEntity<>("CourseDefinition saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getCourseDefinitions")
    public ResponseEntity<List<CourseDefinition>> getCourseDefinitions() {
        List<CourseDefinition> courseDefinitions = courseDefinitionService.GetAllCourseDefinitions();
        if (courseDefinitions != null && !courseDefinitions.isEmpty()) {
            return new ResponseEntity<>(courseDefinitions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/GetCourseDefinition/{id}")
    public ResponseEntity<CourseDefinition> getCourseDefinition(@PathVariable Long id) {
        CourseDefinition courseDefinition = courseDefinitionService.FindCourseDefinition(id);
        if (courseDefinition != null ) {
            return new ResponseEntity<>(courseDefinition, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/DeleteCourseDefinition/{id}")
    public ResponseEntity<?> removeCourseDefinition(@PathVariable Long id){

        String message = courseDefinitionService.deleteCourseDefinition(id);
        if(message!= null){
            return new ResponseEntity<>("CourseDefinition deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
    @PutMapping(value = "/UpdateCourseDefinition/{id}")
    public ResponseEntity<?> updateCourseDefinition(@PathVariable Long id, @RequestBody CourseDefinition courseDefinition){

        String message = courseDefinitionService.UpdateCourseDefinition(id, courseDefinition);
        if(message!= null){
            return new ResponseEntity<>("CourseDefinition updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
}
