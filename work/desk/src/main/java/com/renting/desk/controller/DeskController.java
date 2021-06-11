package com.renting.desk.controller;

import com.renting.desk.model.Desk;
import com.renting.desk.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
@Path("/desks")
public class DeskController {
    @Autowired
    private DeskService deskService;
    @GET
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<Desk> getAllDesks() {
        return deskService.getAllDesks();
    }

    @GET
    @Path("/count")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public long getDeskCount() {
        return deskService.deskCount();
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response createDesk(Desk desk) {
        return Response.ok().entity(deskService.saveDesk(desk)).build();
    }

    @PUT
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response updateDesk(Desk desk) {
        return Response.ok().entity(deskService.updateDesk(desk)).build();
    }
}
