package com.renting.desk.exception;

import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Getter @Setter
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime dateTime;

    public ErrorResponse(Response.Status status, String message) {
        this.status = status.getStatusCode();
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }
}
