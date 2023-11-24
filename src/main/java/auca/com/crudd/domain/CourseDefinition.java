package auca.com.crudd.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class CourseDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String code;

    private String name;


    private String description;

    public CourseDefinition() {
    }

    @Override
    public String toString(){
        return this.name;
    }

    public CourseDefinition(Long ID, String code, String name, String description) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
