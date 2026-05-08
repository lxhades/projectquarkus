package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.request.LoginRequest;
import org.acme.dto.response.ApiResponse;
import org.acme.model.service.AuthService;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {
    @Inject
    AuthService authService;

    @POST
    @Path("/student")
    public Response studentLogin(@Valid LoginRequest req){
    var token=authService.loginStudent(req);
    return Response.ok(ApiResponse.success("Đăng nhập thành công",token)).build();
    }

}
