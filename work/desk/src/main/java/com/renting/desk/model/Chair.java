package com.renting.desk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chair {
    private long id;
    private long desk_id;
    private boolean occupied;
    private long posX;
    private long posY;

}
