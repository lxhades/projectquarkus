package org.acme.model.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.entity.Course;
@ApplicationScoped
public class CourseRepository implements PanacheRepository<Course> {
}