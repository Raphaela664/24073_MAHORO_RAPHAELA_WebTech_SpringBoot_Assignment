package auca.com.crudd.repository;

import auca.com.crudd.domain.Semester;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository  extends JpaRepository<Semester, Long> {
}
