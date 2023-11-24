package auca.com.crudd.service;

import auca.com.crudd.domain.AcademicUnit;
import auca.com.crudd.repository.AcademicUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicUnitService {
    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    public String saveAcademicUnit(AcademicUnit academicUnit){
        if (academicUnit != null){
//            AcademicUnit academicUnit1 = academicUnitRepository.findById(academicUnit.getAcademicUnitId());
            academicUnitRepository.save(academicUnit);
            return "AcademicUnit created successfully";
        }else{
            return null;
        }
    }
    public List<AcademicUnit> GetAllAcademicUnits(){
        return academicUnitRepository.findAll();

    }
    public String deleteAcademicUnit(Long id){
        if (id != null){
            academicUnitRepository.deleteById(id);
            return "AcademicUnit deleted successfully";
        }else{
            return null;
        }
    }

    public AcademicUnit FindAcademicUnit(Long id){
        if (id != null) {
            AcademicUnit academicUnit = academicUnitRepository.findById(id).get();
            return academicUnit;
        }
        else{
            return null;
        }
    }

    public String UpdateAcademicUnit(Long id, AcademicUnit academicUnit){
        if (id != null) {
            AcademicUnit academicUnitFound = academicUnitRepository.findById(id).get();

            academicUnitFound.setCode(academicUnit.getCode());

            if(academicUnit.getUnit() != null){
                academicUnitFound.setUnit(academicUnit.getUnit());
            }
            if(academicUnit.getName() != null){
                academicUnitFound.setName(academicUnit.getName());
            }

            academicUnitRepository.save(academicUnitFound);
            return "academicUnit updated successfully";
        }
        else{
            return null;
        }
    }
}
