package com.renting.desk.controller;


import com.renting.desk.model.ChairRequest;
import com.renting.desk.model.Desk;
import com.renting.desk.model.User;
import com.renting.desk.service.ChairRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
@Path("/chReq")
public class ChairRequestController {
    @Autowired
    private ChairRequestService chairRequestService;

    @GET
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<ChairRequest> getAllChairRequests() {
        return chairRequestService.getAllChairRequests();
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response createChairRequest(ChairRequest newChairRequest) {
        return Response.ok().entity(chairRequestService.saveChairRequest(newChairRequest)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ChairRequest getById(@PathParam("id") String id) {
        return chairRequestService.getChairRequestById(id);
    }

    @PUT
    @Path("/update")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response update(@RequestBody ChairRequest updatedChairRequest) {
        return Response.ok().entity(chairRequestService.updateChairRequest(updatedChairRequest)).build();
    }

}
