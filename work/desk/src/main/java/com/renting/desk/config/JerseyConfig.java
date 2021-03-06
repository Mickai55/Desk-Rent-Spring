package com.renting.desk.config;

import com.renting.desk.controller.ChairRequestController;
import com.renting.desk.controller.DeskController;
import com.renting.desk.controller.RentRequestController;
import com.renting.desk.controller.UserController;
import com.renting.desk.exception.CustomBadRequestException;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserController.class);
        register(DeskController.class);
        register(RentRequestController.class);
        register(ChairRequestController.class);
        register(CustomBadRequestException.class);
    }
}