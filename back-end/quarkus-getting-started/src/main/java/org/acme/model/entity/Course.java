package org.acme.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Course extends PanacheEntityBase {

    @Id
    public String courseCode;

    public String name;

    public Integer credits;

    public Boolean isActive = true;
}