package com.renting.desk.repository;

import com.renting.desk.model.Desk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends MongoRepository<Desk, Long> {

    Desk findByName(String name);

}
