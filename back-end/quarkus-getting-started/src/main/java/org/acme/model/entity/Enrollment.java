package org.acme.model.entity;

import jakarta.persistence.*;
import java.time.Instant;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"msv", "schedule_id"})
)
public class Enrollment extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "msv")
    public Student student;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    public Schedule schedule;

    public String semester;

    public String status = "ENROLLED";

    public Double grade;

    public Instant enrolledAt = Instant.now();
}