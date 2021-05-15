package com.renting.desk.controller;

import com.renting.desk.model.User;
import com.renting.desk.payload.JWTLoginSuccessResponse;
import com.renting.desk.payload.LoginRequest;
import com.renting.desk.repository.UserRepository;
import com.renting.desk.security.JwtTokenProvider;
import com.renting.desk.security.SecurityConstants;
import com.renting.desk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@RestController
@CrossOrigin( origins = "http://localhost:4200")
@Path("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    @POST
    @Path("/register")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response register(User user) {
        return Response.ok().entity(userService.saveUser(user)).build();
    }

    @POST
    @Path("/login")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = SecurityConstants.TOKEN_PREFIX + tokenProvider.generateToken(authentication);
        User user = userRepository.findByUsername(loginRequest.getUsername());
        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt, user.getUserType()));
    }

    @PUT
    @Path("/update")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response update(@RequestBody User updatedUser) {
        return Response.ok().entity(userService.updateUser(updatedUser)).build();
    }

    @POST
    @Path("/getUser")
    @Produces(APPLICATION_JSON)
//    @Consumes(APPLICATION_JSON)
    public Response getUser(@RequestBody String username) {
        return Response.ok().entity(userService.getUser(username)).build();
    }
}
