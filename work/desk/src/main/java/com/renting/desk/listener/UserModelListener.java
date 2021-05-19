package com.renting.desk.listener;

import com.renting.desk.model.User;
import com.renting.desk.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserModelListener extends AbstractMongoEventListener<User> {
    @Autowired
    private SequenceGeneratorService service;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
        if (event.getSource().get_id() == null || event.getSource().get_id() < 1) {
            event.getSource().set_id(service.generateSequence(User.SEQUENCE_NAME));
        }
    }
}
