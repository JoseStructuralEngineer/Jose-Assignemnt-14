package com.assignments.JoseAssignemnt14.service;

import com.assignments.JoseAssignemnt14.domain.User;
import com.assignments.JoseAssignemnt14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepo;

    public List<User> findByName(String name) {
        return userRepo.findByName(name);
    }

    public User createUser(String name) {

        // CascadeTypes => PERSIST, MERGE, REMOVE
        // PERSIST new User() <-> new Address()  --> saveUser()
        // MERGE   existingUser -> new/updating Address() --> saveUser()
        // REMOVE  existingUser -> setAddress(null) -- saveUser()

        System.out.println(name);
        User user = new User();
        user.setName(name);

        return userRepo.save(user);
    }
}
