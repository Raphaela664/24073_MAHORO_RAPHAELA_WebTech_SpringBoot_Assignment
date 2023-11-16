package auca.com.crudd.controller;

import auca.com.crudd.domain.Semester;
import auca.com.crudd.domain.Semester;
import auca.com.crudd.repository.SemesterRepository;
import auca.com.crudd.repository.SemesterRepository;
import auca.com.crudd.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(
        value = "/semester",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @PostMapping(value = "/saveSemester")
    public ResponseEntity<?> createSemester(@RequestBody Semester semester){
        if (semester != null){
            String message = semesterService.saveSemester(semester);
            if(message!= null){
                return new ResponseEntity<>("Semester saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getSemesters")
    public ResponseEntity<List<Semester>> getSemesters() {
        List<Semester> semesters = semesterService.GetAllSemester();
        if (semesters != null && !semesters.isEmpty()) {
            return new ResponseEntity<>(semesters, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping(value = "/GetSemester/{id}")
//    public ResponseEntity<Semester> getSemester(@PathVariable Long id) {
//        Semester semester = semesterService.FindSemester(id);
//        if (semester != null ) {
//            return new ResponseEntity<>(semester, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping(value = "/DeleteSemester/{id}")
    public ResponseEntity<?> removeSemester(@PathVariable Long id){

        String message = semesterService.deleteSemester(id);
        if(message!= null){
            return new ResponseEntity<>("Semester deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
    @PutMapping(value = "/UpdateSemester/{id}")
    public ResponseEntity<?> updateSemester(@PathVariable Long id, @RequestBody Semester semester){

        String message = semesterService.UpdateSemester(id, semester);
        if(message!= null){
            return new ResponseEntity<>("Semester updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }

}
