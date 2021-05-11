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

@Service
public class DeskService {
    @Autowired
    private DeskRepository deskRepository;

    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    public List<Desk> getAllDesks() {
        return deskRepository.findAll();
    }

    public Desk saveDesk(Desk newDesk) {
        try {
            LOG.debug("DeskService: Start Save Desk");

            if(deskRepository.findByName(newDesk.getName()) != null)
                throw new BadRequestException("Desk already exists");

            for (int i = 1; i <= newDesk.getTotal_spaces(); i++) {
                newDesk.getChairs().add(createChair(i, newDesk.getId(), 0, 0));
            }
            return deskRepository.save(newDesk);
        }
        finally {
            LOG.debug("UserService: End Save Desk");
        }
    }

    private Chair createChair(long id, long desk_id, long posX, long posY) {
        Chair chair = new Chair();
        chair.setId(id);
        chair.setDesk_id(desk_id);
        chair.setPosX(posX);
        chair.setPosY(posY);
        return chair;
    }
}
