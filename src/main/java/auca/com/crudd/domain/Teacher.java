package auca.com.crudd.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String teacher_code;

    private String names;


    @Enumerated(EnumType.STRING)
    private EQualification qualification;

    public Teacher() {
    }
    @Override
    public String toString(){
        return this.names;
    }

    public Teacher(Long ID, String teacher_code, String names, EQualification qualification) {
        this.ID = ID;
        this.teacher_code = teacher_code;
        this.names = names;
        this.qualification = qualification;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTeacher_code() {
        return teacher_code;
    }

    public void setTeacher_code(String teacher_code) {
        this.teacher_code = teacher_code;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public EQualification getQualification() {
        return qualification;
    }

    public void setQualification(EQualification qualification) {
        this.qualification = qualification;
    }
}
