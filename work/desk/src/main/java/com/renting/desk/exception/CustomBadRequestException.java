package com.renting.desk.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CustomBadRequestException extends Exception implements ExceptionMapper<BadRequestException> {
    private static final Logger LOG = LoggerFactory.getLogger(CustomBadRequestException.class);
    private static final Response.Status status = Response.Status.BAD_REQUEST;
    @Override
    public Response toResponse(BadRequestException e) {
        LOG.error("CustomBadRequestException handled: {} ", e.getMessage());
        return Response.status(status).entity(new ErrorResponse(status, e.getMessage())).build();
    }
}
