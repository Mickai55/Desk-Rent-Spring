package com.renting.desk.service;

import com.renting.desk.model.ChairRequest;
import com.renting.desk.model.RentRequest;
import com.renting.desk.repository.RentRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentRequestService {
    @Autowired
    private RentRequestRepository rentRequestRepository;
    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    public List<RentRequest> getAllRentRequests() { return rentRequestRepository.findAll(); }

    public RentRequest saveRentRequest(RentRequest newRentRequest) {
        try {
            LOG.debug("RentRequestService: Start Save RentRequest");
            return rentRequestRepository.save(newRentRequest);
        }
        finally {
            LOG.debug("RentRequestService: End Save RentRequest");
        }
    }

    public RentRequest getRentRequestById(String id) {
        Optional<RentRequest> data = rentRequestRepository.findById(Long.parseLong(id));
        return data.get();
    }

    public RentRequest updateRentRequest(RentRequest rentRequest) {
        Optional<RentRequest> data = rentRequestRepository.findById(rentRequest.get_id());
        data.get().setRequests(rentRequest.getRequests());
        data.get().setStatus(rentRequest.getStatus());

        return rentRequestRepository.save(data.get());
    }
}
