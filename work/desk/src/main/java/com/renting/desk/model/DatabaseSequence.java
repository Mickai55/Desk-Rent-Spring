package com.renting.desk.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Document(collection = "database_sequence")
public class DatabaseSequence {
    @Id
    private String id;

    private long counter;
}
