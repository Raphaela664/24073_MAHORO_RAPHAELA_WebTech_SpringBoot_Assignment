package auca.com.crudd.repository;


import auca.com.crudd.domain.Course;
import auca.com.crudd.domain.StudentCourse;
import auca.com.crudd.domain.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
  List<StudentCourse> findCoursesByStudentRegistration(StudentRegistration studentRegistration);
  List<StudentCourse> findByCourseAndStudentRegistration(Course course, StudentRegistration studentRegistration);

}
