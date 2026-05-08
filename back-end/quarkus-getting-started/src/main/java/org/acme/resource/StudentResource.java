package org.acme.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;

import java.util.List;

import org.acme.model.entity.Student;
import org.acme.model.service.StudentService;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @Inject
    StudentService service;


    // GET ALL
    @GET
    public List<Student> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GET
    @Path("/{msv}")
    public Student getById(@PathParam("msv") String msv) {
        return service.getByMsv(msv);
    }

    // CREATE
    @POST
    public Response create(Student s) {

        service.create(s);

        return Response
                .status(Response.Status.CREATED)
                .entity("Tạo sinh viên thành công")
                .build();
    }

    // DELETE
    @DELETE
    @Path("/{msv}")
    public Response deleteById(@PathParam("msv") String msv) {

        service.deleteByMsv(msv);

        return Response
                .ok("Xóa sinh viên thành công")
                .build();
    }
    @PUT
    @Path("/{msv}")
    public Response update(
            @PathParam("msv") String msv,
            Student s) {

        service.update(msv, s);

        return Response.ok("Cập nhật thành công").build();
    }
}