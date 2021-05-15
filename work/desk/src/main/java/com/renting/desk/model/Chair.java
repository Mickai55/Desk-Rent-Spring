package com.renting.desk.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Chair {
    private long _id;
    private long desk_id;
    private boolean occupied;
    private List<String> occupied_days = new ArrayList<>();
    private List<Integer> requests = new ArrayList<>();
    private double posX;
    private double posY;

}
