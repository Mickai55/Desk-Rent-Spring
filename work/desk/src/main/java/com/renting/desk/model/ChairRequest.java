package com.renting.desk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChairRequest {
    private long _id;
    private long desk_id;
    private long chair_id;
    private String status;
    private List<String> days = new ArrayList<>();
}
