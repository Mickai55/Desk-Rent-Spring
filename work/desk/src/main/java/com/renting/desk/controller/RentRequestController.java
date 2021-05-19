package com.renting.desk.controller;

import com.renting.desk.model.ChairRequest;
import com.renting.desk.model.RentRequest;
import com.renting.desk.service.RentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@CrossOrigin("*")
@Path("/rentReq")
public class RentRequestController {
    @Autowired
    private RentRequestService rentRequestService;

    @GET
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<RentRequest> getAllRentRequests() { return rentRequestService.getAllRentRequests();}

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response createRentRequest(RentRequest newRentRequest) {
        return Response.ok().entity(rentRequestService.saveRentRequest(newRentRequest)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public RentRequest getById(@PathParam("id") String id) {
        return rentRequestService.getRentRequestById(id);
    }

    @PUT
    @Path("/update")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response update(@RequestBody RentRequest updatedRentRequest) {
        return Response.ok().entity(rentRequestService.updateRentRequest(updatedRentRequest)).build();
    }

}
