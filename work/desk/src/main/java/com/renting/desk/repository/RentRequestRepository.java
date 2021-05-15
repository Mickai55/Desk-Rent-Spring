package com.renting.desk.repository;

import com.renting.desk.model.RentRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentRequestRepository  extends MongoRepository<RentRequest, Long> {
}
