package auca.com.crudd.service;

import auca.com.crudd.domain.*;
import auca.com.crudd.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public String saveCourse(Course course){
        if (course != null){
            //   Course course1 = courseRepository.findById(course.getCourse_id());
            courseRepository.save(course);
            return "Course created successfully";
        }else{
            return null;
        }
    }

    public List<Course> GetAllCourse(){
        return courseRepository.findAll();

    }
    public String deleteCourse(Long id){
        if (id != null){
            courseRepository.deleteById(id);
            return "Course deleted successfully";
        }else{
            return null;
        }
    }
    public String UpdateCourse(Long id, Course course){
        if (id != null) {
            Course courseFound = courseRepository.findById(id).get();
            courseFound.setDefinition(course.getDefinition());
            courseFound.setSemester(course.getSemester());
            courseFound.setAssistant(course.getAssistant());
            courseFound.setTutor(course.getTutor());
            courseFound.setUnit(course.getUnit());
            courseRepository.save(courseFound);
            return "course updated successfully";
        }
        else{
            return null;
        }
    }
    public List<Course> getCoursesPerUnitAndSemester(AcademicUnit unit, Semester semester) {

        return courseRepository.findCourseByUnitAndSemester(unit,semester);
    }

}
