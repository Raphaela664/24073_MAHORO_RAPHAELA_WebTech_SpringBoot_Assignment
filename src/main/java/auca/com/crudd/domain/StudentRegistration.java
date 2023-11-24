package auca.com.crudd.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reg_no")
    private Long id;

    private LocalDate registrationDate;
    @OneToOne
    private Student student;
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private AcademicUnit academicUnit;
    @OneToOne
    private Semester semester;

    @OneToMany(mappedBy = "studentRegistration")
    @JsonBackReference
    private List<StudentCourse> courses;

    public StudentRegistration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public List<StudentCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<StudentCourse> courses) {
        this.courses = courses;
    }

    public StudentRegistration(Long id) {
        this.id = id;
    }

    public StudentRegistration(Semester semester) {
        this.semester = semester;
    }

    public StudentRegistration(Student student) {
        this.student = student;
    }

    public StudentRegistration(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }
}
