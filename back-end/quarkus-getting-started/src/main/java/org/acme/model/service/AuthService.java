package org.acme.model.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.acme.dto.request.LoginRequest;
import org.acme.model.entity.Student;
import org.acme.security.JwtService;

@ApplicationScoped
public class AuthService {

    @Inject
    StudentService studentService;

    @Inject
    JwtService jwtService;

    public String loginStudent(LoginRequest req) {


        Student student = studentService.getByMsv(req.msv);

        if (!req.password.equals(student.password)) {
            throw new IllegalArgumentException("Mật khẩu không đúng");
        }


        String token =
                jwtService.generateToken(
                        student.msv,
                        "STUDENT"
                );

        return token;
    }
}