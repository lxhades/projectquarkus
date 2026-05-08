package org.acme.model.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.entity.Student;
import org.acme.model.repository.StudentRepository;

import java.util.List;

@ApplicationScoped
public class StudentService {

    @Inject
    StudentRepository repo;

    public List<Student> getAll() {
        return repo.listAll();
    }

    public Student getByMsv(String msv) {

        Student s = repo.findByMsv(msv);

        if (s == null) {
            throw new RuntimeException("Không tìm thấy sinh viên");
        }

        return s;
    }

    @Transactional
    public void create(Student s) {
        repo.persist(s);
    }

    @Transactional
    public void deleteByMsv(String msv) {

        Student s = repo.findByMsv(msv);

        if (s == null) {
            throw new RuntimeException("Không tìm thấy sinh viên");
        }

        repo.delete(s);
    }

    @Transactional
    public void update(String msv, Student req) {

        Student s = repo.findByMsv(msv);

        if (s == null) {
            throw new RuntimeException("Không tìm thấy sinh vien");
        }

        s.name = req.name;
        s.password = req.password;
        s.credit = req.credit;
    }
}