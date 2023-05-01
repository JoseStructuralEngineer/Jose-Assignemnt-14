package com.assignments.JoseAssignemnt14.service;


import com.assignments.JoseAssignemnt14.domain.Channel;
import com.assignments.JoseAssignemnt14.domain.Message;
import com.assignments.JoseAssignemnt14.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelServices {


    @Autowired
    private ChannelRepository channelRepo;

    public Channel saveChannel(Channel channel) {

        // CascadeTypes => PERSIST, MERGE, REMOVE
        // PERSIST new User() <-> new Address()  --> saveUser()
        // MERGE   existingUser -> new/updating Address() --> saveUser()
        // REMOVE  existingUser -> setAddress(null) -- saveUser()


        return channelRepo.save(channel);
    }

    public List<Channel> findAll(){
        return channelRepo.findAll();
    }

    public Channel findById(Long userId){
        Optional<Channel> channelOpt = channelRepo.findById(userId);
        return channelOpt.orElse(new Channel());
    }



}
