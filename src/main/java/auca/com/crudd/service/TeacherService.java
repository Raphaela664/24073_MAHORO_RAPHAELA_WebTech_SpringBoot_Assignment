package auca.com.crudd.service;

import auca.com.crudd.domain.Teacher;
import auca.com.crudd.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public String saveTeacher(Teacher teacher){
        if (teacher != null){
//            Teacher teacher1 = teacherRepository.findById(teacher.getTeacherId());
            teacherRepository.save(teacher);
            return "Teacher created successfully";
        }else{
            return null;
        }
    }
    public List<Teacher> GetAllTeachers(){
        return teacherRepository.findAll();

    }
    public String deleteTeacher(Long id){
        if (id != null){
            teacherRepository.deleteById(id);
            return "Teacher deleted successfully";
        }else{
            return null;
        }
    }

    public Teacher FindTeacher(Long id){
        if (id != null) {
            Teacher teacher = teacherRepository.findById(id).get();
            return teacher;
        }
        else{
            return null;
        }
    }

    public String UpdateTeacher(Long id, Teacher teacher){
        if (id != null) {
            Teacher teacherFound = teacherRepository.findById(id).get();
            if(teacherFound.getNames() != null) {
                teacherFound.setNames(teacher.getNames());
            }
            if(teacherFound.getQualification() != null) {
                teacherFound.setQualification(teacher.getQualification());
            }
            if(teacherFound.getTeacher_code() != null) {
                teacherFound.setTeacher_code(teacher.getTeacher_code());
            }
            teacherRepository.save(teacherFound);
            return "teacher updated successfully";
        }
        else{
            return null;
        }
    }
}
