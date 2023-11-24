package auca.com.crudd.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.UUID;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long Course_id;
    @ManyToOne
   private CourseDefinition definition;
   @ManyToOne
   private AcademicUnit unit;

   @ManyToOne
   private Teacher tutor;

   @ManyToOne

    private Teacher assistant;

   @ManyToOne

   private Semester semester;

    public Course() {
    }

    public Course(Long course_id, CourseDefinition definition, AcademicUnit unit, Teacher tutor, Teacher assistant, Semester semester) {
        Course_id = course_id;
        this.definition = definition;
        this.unit = unit;
        this.tutor = tutor;
        this.assistant = assistant;
        this.semester = semester;
    }

    public Long getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(Long course_id) {
        Course_id = course_id;
    }

    public CourseDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(CourseDefinition definition) {
        this.definition = definition;
    }

    public AcademicUnit getUnit() {
        return unit;
    }

    public void setUnit(AcademicUnit unit) {
        this.unit = unit;
    }

    public Teacher getTutor() {
        return tutor;
    }

    public void setTutor(Teacher tutor) {
        this.tutor = tutor;
    }

    public Teacher getAssistant() {
        return assistant;
    }

    public void setAssistant(Teacher assistant) {
        this.assistant = assistant;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Course(AcademicUnit unit, Semester semester) {
        this.unit = unit;
        this.semester = semester;
    }
}
