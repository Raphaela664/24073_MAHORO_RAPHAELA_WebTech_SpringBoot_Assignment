package auca.com.crudd.service;

import auca.com.crudd.domain.CourseDefinition;
import auca.com.crudd.repository.CourseDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDefinitionService {
    @Autowired
    private CourseDefinitionRepository courseDefinitionRepository;

    public String saveCourseDefinition(CourseDefinition courseDefinition){
        if (courseDefinition != null){
//            CourseDefinition courseDefinition1 = courseDefinitionRepository.findById(courseDefinition.getCourseDefinitionId());
            courseDefinitionRepository.save(courseDefinition);
            return "CourseDefinition created successfully";
        }else{
            return null;
        }
    }
    public List<CourseDefinition> GetAllCourseDefinitions(){
        return courseDefinitionRepository.findAll();

    }
    public String deleteCourseDefinition(Long id){
        if (id != null){
            courseDefinitionRepository.deleteById(id);
            return "CourseDefinition deleted successfully";
        }else{
            return null;
        }
    }

    public CourseDefinition FindCourseDefinition(Long id){
        if (id != null) {
            CourseDefinition courseDefinition = courseDefinitionRepository.findById(id).get();
            return courseDefinition;
        }
        else{
            return null;
        }
    }

    public String UpdateCourseDefinition(Long id, CourseDefinition courseDefinition){
        if (id != null) {
            CourseDefinition courseDefinitionFound = courseDefinitionRepository.findById(id).get();
            courseDefinitionFound.setCode(courseDefinition.getCode());
            courseDefinitionFound.setName(courseDefinition.getName());
            courseDefinitionFound.setDescription(courseDefinition.getDescription());
            courseDefinitionRepository.save(courseDefinitionFound);
            return "courseDefinition updated successfully";
        }
        else{
            return null;
        }
    }
}
