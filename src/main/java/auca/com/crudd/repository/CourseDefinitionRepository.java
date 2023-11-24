package auca.com.crudd.repository;

import auca.com.crudd.domain.CourseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDefinitionRepository extends JpaRepository<CourseDefinition, Long> {
}
