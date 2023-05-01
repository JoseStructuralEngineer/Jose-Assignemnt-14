package com.assignments.JoseAssignemnt14.service;

import com.assignments.JoseAssignemnt14.domain.Channel;
import com.assignments.JoseAssignemnt14.domain.Message;
import com.assignments.JoseAssignemnt14.domain.User;
import com.assignments.JoseAssignemnt14.repository.MessageRepository;
import com.assignments.JoseAssignemnt14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServices {

    @Autowired
    private MessageRepository messageRepo;


    public Message saveMessage(Message message) {

        // CascadeTypes => PERSIST, MERGE, REMOVE
        // PERSIST new User() <-> new Address()  --> saveUser()
        // MERGE   existingUser -> new/updating Address() --> saveUser()
        // REMOVE  existingUser -> setAddress(null) -- saveUser()


        return messageRepo.save(message);
    }

    public List<Message> findByChannelId(Long channelId){

        return messageRepo.findByChannelId(channelId);

    }

}
