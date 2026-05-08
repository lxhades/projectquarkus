package org.acme.model.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.repository.CourseRepository;

@ApplicationScoped
public class CourseService {
    @Inject
    CourseRepository courseRepository;

}
