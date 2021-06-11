package com.renting.desk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Desk {
    private Long _id;
    @Field
    private String name;
    @Field
    private String address;
    @Field
    private long available_spaces;
    @Field
    private long total_spaces;
    @Field
    private List<Chair> chairs = new ArrayList<>();
    @Field
    private String dimension;
    @Field
    private List<String> images = new ArrayList<>();
    @Field
    private boolean has_location;
    @Field
    private double lat;
    @Field
    private double lon;
}
