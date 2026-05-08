package org.acme.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;

import org.acme.model.entity.Student;
import org.acme.model.service.EnrollmentService;

import java.util.List;

@Path("/enrollments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnrollmentResource {

    @Inject
    EnrollmentService service;

    @POST
    @Path("/register")
    @RolesAllowed("STUDENT")
    public String register(@QueryParam("msv") String msv,
                            @QueryParam("scheduleId") Long scheduleId) {
        return service.register(msv, scheduleId);
    }

}