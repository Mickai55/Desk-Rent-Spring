package com.renting.desk.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.renting.desk.model.Chair;
import com.renting.desk.model.Desk;
import com.renting.desk.model.User;
import com.renting.desk.model.UserType;
import com.renting.desk.repository.DeskRepository;
import com.renting.desk.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "001", id = "createUser", author = "author")
    public void createUser(UserRepository repo) {
        List<User> list = new ArrayList<>();

        list.add(new User("admin", new BCryptPasswordEncoder().encode("admin"), UserType.ADMIN));
        list.add(new User("normal", new BCryptPasswordEncoder().encode("normal"), UserType.NORMAL));

        repo.insert(list);
    }

    @ChangeSet(order = "002", id = "createDeskDefault", author = "author")
    public void createDeskDefault(DeskRepository repo) {
        List<Desk> list = new ArrayList<>();

//        list.add(createDesk(1, "Google", "Bucharest", 5));
//        list.add(createDesk(2, "Amazon", "Bucharest", 10));

//        repo.insert(list);
    }

    private Desk createDesk(long id, String name, String address, long total_spaces) {
        Desk desk = new Desk();
//        desk.setId(id);
        desk.setName(name);
        desk.setAddress(address);
        desk.setTotal_spaces(total_spaces);

        for (int i = 1; i <= total_spaces; i++) {
            desk.getChairs().add(createChair(i, id, 0, 0));
        }

        return desk;
    }

    private Chair createChair(long id, long desk_id, long posX, long posY) {
        Chair chair = new Chair();
        chair.set_id(id);
        chair.setDesk_id(desk_id);
        chair.setPosX(posX);
        chair.setPosY(posY);
        return chair;
    }
}