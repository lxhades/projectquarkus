package org.acme.model.repository;

import jakarta.enterprise.context.ApplicationScoped;

import org.acme.model.entity.Schedule;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
@ApplicationScoped
public class ScheduleRepository implements PanacheRepositoryBase<Schedule,Long> {
}