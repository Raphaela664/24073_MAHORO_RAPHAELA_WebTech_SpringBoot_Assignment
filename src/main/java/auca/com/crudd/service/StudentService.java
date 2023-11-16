package auca.com.crudd.service;

import auca.com.crudd.domain.Student;
import auca.com.crudd.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(Student student){
        if (student != null){
//            Student student1 = studentRepository.findById(student.getStudentId());
            studentRepository.save(student);
            return "Student created successfully";
        }else{
            return null;
        }
    }
    public  List<Student> GetAllStudents(){
        return studentRepository.findAll();

    }
    public String deleteStudent(Long id){
        if (id != null){
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        }else{
            return null;
        }
    }

    public Student FindStudent(Long id){
        if (id != null) {
            Student student = studentRepository.findById(id).get();
            return student;
        }
        else{
                return null;
        }
    }

    public String UpdateStudent(Long id, Student student){
        if (id != null) {
            Student studentFound = studentRepository.findById(id).get();
            studentFound.setStudentName(student.getStudentName());
            studentFound.setDateofBirth(student.getDateofBirth());
            studentRepository.save(studentFound);
            return "student updated successfully";
        }
        else{
            return null;
        }
    }


}
