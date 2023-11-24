package auca.com.crudd.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Long ID;
    private int code;
    private String name;

    @Enumerated(EnumType.STRING)
    private EAcademicUnit Unit;

    public AcademicUnit() {
    }

    public AcademicUnit(Long ID) {
        this.ID = ID;
    }

    public AcademicUnit(Long ID, int code, String name, EAcademicUnit unit) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        Unit = unit;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EAcademicUnit getUnit() {
        return Unit;
    }

    public void setUnit(EAcademicUnit unit) {
        Unit = unit;
    }
}
