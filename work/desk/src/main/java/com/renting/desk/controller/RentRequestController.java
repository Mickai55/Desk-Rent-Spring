package com.renting.desk.controller;

import com.renting.desk.model.RentRequest;
import com.renting.desk.service.RentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@CrossOrigin("*")
@Path("/chReq")
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

}
