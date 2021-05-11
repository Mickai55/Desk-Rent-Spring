package com.renting.desk.service;

import com.renting.desk.model.User;
import com.renting.desk.model.UserType;
import com.renting.desk.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User updateUser(String username, User updatedUser) {
        User u = userRepository.findByUsername(username);

        if(u != null)
            throw new BadRequestException("Username already exists");

        u.setEmail(updatedUser.getEmail());
        u.setPhone(updatedUser.getPhone());
        u.setLocation(updatedUser.getLocation());
        u.setWebsite_link(updatedUser.getWebsite_link());

        return userRepository.save(u);
    }
}
