package com.renting.desk.service;

import com.renting.desk.model.ChairRequest;
import com.renting.desk.repository.ChairRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChairRequestService {
    @Autowired
    private ChairRequestRepository chairRequestRepository;
    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    public List<ChairRequest> getAllChairRequests() {
        return chairRequestRepository.findAll();
    }

    public ChairRequest saveChairRequest(ChairRequest newChairRequest) {
        try {
            LOG.debug("ChairRequestService: Start Save ChairRequest");
            return chairRequestRepository.save(newChairRequest);
        }
        finally {
            LOG.debug("ChairRequestService: End Save ChairRequest");
        }
    }

    public ChairRequest getChairRequestById(String id) {
        Optional<ChairRequest> tutorialData = chairRequestRepository.findById(Long.parseLong(id));

        return tutorialData.get();

    }
}
