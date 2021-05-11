package com.renting.desk.payload;


import com.renting.desk.model.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTLoginSuccessResponse {
    private boolean success;
    private String token;
    private UserType userType;
    public JWTLoginSuccessResponse(boolean success, String token, UserType userType) {
        this.success = success;
        this.token = token;
        this.userType = userType;
    }
}
