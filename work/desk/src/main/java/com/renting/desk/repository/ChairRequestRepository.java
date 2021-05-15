package com.renting.desk.repository;

import com.renting.desk.model.ChairRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChairRequestRepository  extends MongoRepository<ChairRequest, Long> {
}
