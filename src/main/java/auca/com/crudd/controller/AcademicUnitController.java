package auca.com.crudd.controller;

import auca.com.crudd.domain.AcademicUnit;
import auca.com.crudd.service.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/academicUnit",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class AcademicUnitController {

    @Autowired
    private AcademicUnitService academicUnitService;
    @PostMapping(value = "/saveAcademicUnit")
    public ResponseEntity<?> createAcademicUnit(@RequestBody AcademicUnit academicUnit){
        if (academicUnit != null){
            String message = academicUnitService.saveAcademicUnit(academicUnit);
            if(message!= null){
                return new ResponseEntity<>("AcademicUnit saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
            }
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }

    }
    @GetMapping(value = "/getAcademicUnits")
    public ResponseEntity<List<AcademicUnit>> getAcademicUnits() {
        List<AcademicUnit> academicUnits = academicUnitService.GetAllAcademicUnits();
        if (academicUnits != null && !academicUnits.isEmpty()) {
            return new ResponseEntity<>(academicUnits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/GetAcademicUnit/{id}")
    public ResponseEntity<AcademicUnit> getAcademicUnit(@PathVariable Long id) {
        AcademicUnit academicUnit = academicUnitService.FindAcademicUnit(id);
        if (academicUnit != null ) {
            return new ResponseEntity<>(academicUnit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/DeleteAcademicUnit/{id}")
    public ResponseEntity<?> removeAcademicUnit(@PathVariable Long id){

        String message = academicUnitService.deleteAcademicUnit(id);
        if(message!= null){
            return new ResponseEntity<>("AcademicUnit deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
    @PutMapping(value = "/UpdateAcademicUnit/{id}")
    public ResponseEntity<?> updateAcademicUnit(@PathVariable Long id, @RequestBody AcademicUnit academicUnit){

        String message = academicUnitService.UpdateAcademicUnit(id, academicUnit);
        if(message!= null){
            return new ResponseEntity<>("AcademicUnit updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_GATEWAY);
        }



    }
}
