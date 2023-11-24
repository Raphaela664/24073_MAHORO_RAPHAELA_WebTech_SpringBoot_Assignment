package auca.com.crudd.repository;

import auca.com.crudd.domain.Student;
import auca.com.crudd.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
