package auca.com.crudd.repository;

import auca.com.crudd.domain.AcademicUnit;
import auca.com.crudd.domain.Semester;
import auca.com.crudd.domain.Student;
import auca.com.crudd.domain.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {
    List<StudentRegistration> findBySemester(Semester semester);
    List<StudentRegistration> findByAcademicUnitAndSemester(AcademicUnit academicUnit, Semester semester);



}
