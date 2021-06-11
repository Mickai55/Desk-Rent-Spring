package com.renting.desk.service;

import com.renting.desk.model.Chair;
import com.renting.desk.model.Desk;
import com.renting.desk.model.User;
import com.renting.desk.repository.DeskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

@Service
public class DeskService {
    @Autowired
    private DeskRepository deskRepository;

    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    public List<Desk> getAllDesks() {
        return deskRepository.findAll();
    }

    public long deskCount() {
        return deskRepository.count();
    }

    public Desk saveDesk(Desk newDesk) {
        try {
            LOG.debug("DeskService: Start Save Desk");
            return deskRepository.save(newDesk);
        }
        finally {
            LOG.debug("UserService: End Save Desk");
        }
    }

    public Desk updateDesk(Desk updatedDesk) {
        Desk u = deskRepository.findByName(updatedDesk.getName());

        if(u == null)
            throw new BadRequestException("Desk not found");

        u.setChairs(updatedDesk.getChairs());
        u.setAvailable_spaces(updatedDesk.getAvailable_spaces());

        return deskRepository.save(u);
    }
}
