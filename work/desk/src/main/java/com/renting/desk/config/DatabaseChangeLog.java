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

}