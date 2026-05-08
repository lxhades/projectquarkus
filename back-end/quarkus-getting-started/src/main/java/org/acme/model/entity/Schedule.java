package org.acme.model.entity;

import jakarta.persistence.*;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Schedule extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course course;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    public Lecturer lecturer;

    public String semester;

    public Integer dayOfWeek;

    public java.time.LocalTime startTime;

    public java.time.LocalTime endTime;

    public String room;

    public Integer capacity = 40;
}