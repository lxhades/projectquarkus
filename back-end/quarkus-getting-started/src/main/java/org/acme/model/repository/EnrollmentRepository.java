package org.acme.model.repository;

import java.util.UUID;
import org.acme.model.entity.Enrollment;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnrollmentRepository implements PanacheRepository<Enrollment> {

    public boolean existsStudentSchedule(String msv, Long scheduleId) {
        return count("student.msv = ?1 and schedule.id = ?2", msv, scheduleId) > 0;
    }
}