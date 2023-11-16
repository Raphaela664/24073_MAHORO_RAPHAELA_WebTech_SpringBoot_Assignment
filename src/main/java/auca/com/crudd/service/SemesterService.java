package auca.com.crudd.service;

import auca.com.crudd.domain.Semester;
import auca.com.crudd.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SemesterService {
    @Autowired
    private SemesterRepository semesterRepository;
    public String saveSemester(Semester semester){
        if (semester != null){
            //   Semester semester1 = semesterRepository.findById(semester.getSemester_id());
            semesterRepository.save(semester);
            return "Semester created successfully";
        }else{
            return null;
        }
    }

    public List<Semester> GetAllSemester(){
        return semesterRepository.findAll();

    }
    public String deleteSemester(Long id){
        if (id != null){
            semesterRepository.deleteById(id);
            return "Semester deleted successfully";
        }else{
            return null;
        }
    }
    public String UpdateSemester(Long id, Semester semester){
        if (id != null) {
            Semester semesterFound = semesterRepository.findById(id).get();
            semesterFound.setName(semester.getName());
            semesterFound.setStartDate(semester.getStartDate());
            semesterFound.setEndDate(semester.getEndDate());
            semesterRepository.save(semesterFound);
            return "semester updated successfully";
        }
        else{
            return null;
        }
    }
}
