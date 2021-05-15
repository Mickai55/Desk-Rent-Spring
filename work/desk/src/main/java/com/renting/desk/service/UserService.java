package com.renting.desk.service;

import com.renting.desk.model.User;
import com.renting.desk.model.UserType;
import com.renting.desk.repository.UserRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser) {
        try {
            LOG.debug("UserService: Start Save User");
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            newUser.setUserType(UserType.NORMAL);
            if(userRepository.findByUsername(newUser.getUsername()) != null)
                throw new BadRequestException("Username already exists");
            return userRepository.save(newUser);
        }
        finally {
            LOG.debug("UserService: End Save User");
        }
    }

    public User updateUser(User updatedUser) {
        User u = userRepository.findByUsername(updatedUser.getUsername());

        if(u == null)
            throw new BadRequestException("Username not found");

        u.setEmail(updatedUser.getEmail());
        u.setPhone(updatedUser.getPhone());
        u.setLocation(updatedUser.getLocation());
        u.setWebsite_link(updatedUser.getWebsite_link());
        u.setPhoto(updatedUser.getPhoto());

        return userRepository.save(u);
    }

    public User getUser(String username) {
        User user = userRepository.findByUsername(username);

        if(user == null)
            throw new BadRequestException("Username not found");
        return user;
    }
}
