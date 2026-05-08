package org.acme.model.repository;

import org.acme.model.entity.Student;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<Student> {

    public Student findByMsv(String msv) {
        return find("msv", msv).firstResult();
    }
}