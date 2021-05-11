package com.renting.desk.config;

import com.renting.desk.controller.DeskController;
import com.renting.desk.controller.UserController;
import com.renting.desk.exception.CustomBadRequestException;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
//register resources
        register(UserController.class);
        register(DeskController.class);
//register custom errors
        register(CustomBadRequestException.class);

//        register(CorsFilter.class);

    }
}