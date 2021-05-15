package com.renting.desk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RentRequest {
    private long _id;
    private User user;
    private List<Integer> requests = new ArrayList<>();
    private String status;
    private String timestamp;
}
