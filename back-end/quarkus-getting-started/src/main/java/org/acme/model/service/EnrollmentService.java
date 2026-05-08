package org.acme.model.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.acme.model.entity.Enrollment;
import org.acme.model.entity.Schedule;
import org.acme.model.entity.Student;
import org.acme.model.repository.CourseRepository;
import org.acme.model.repository.EnrollmentRepository;
import org.acme.model.repository.ScheduleRepository;
import org.acme.model.repository.StudentRepository;

@ApplicationScoped
public class EnrollmentService {

    @Inject
    EnrollmentRepository enrollmentRepo;

    @Inject
    ScheduleRepository scheduleRepo;

    @Inject
    StudentRepository studentRepo;

    @Transactional
    public String register(String msv, Long scheduleId) {
        
        // 1. Check trùng đăng ký
        if (enrollmentRepo.existsStudentSchedule(msv, scheduleId)) {
            return "Sinh viên đã đăng ký lớp này!";
        }

        // 2. Lấy schedule
        Schedule schedule = scheduleRepo.findById(scheduleId);
        if (schedule == null) {
            return "Không tìm thấy lịch học!";
        }

        // 3. Check số tín chỉ (logic đơn giản)
        Student student = studentRepo.findByMsv(msv);
        double currentCredit = student.credit == null ? 0 : student.credit;

        if (currentCredit >= 30) {
            return "Vượt quá số tín chỉ cho phép!";
        }

        // 4. Tạo enrollment
        Enrollment e = new Enrollment();
        e.student = student;
        e.schedule = schedule;
        e.semester = schedule.semester;
        e.status = "ENROLLED";

        enrollmentRepo.persist(e);

        return "Đăng ký thành công!";
    }

}
