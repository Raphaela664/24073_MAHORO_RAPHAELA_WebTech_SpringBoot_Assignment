package auca.com.crudd.repository;

import auca.com.crudd.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByUnitAndSemester(AcademicUnit academicUnit, Semester semester);
}
