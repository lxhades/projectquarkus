package org.acme.model.entity; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Student extends PanacheEntityBase {

    @Id
    public String msv;

    public String name;

    public LocalDate birthDate;

    public String className;

    public String email;

    public String password;

    public Boolean isActive = true;

    public Double credit = 0.0;
}