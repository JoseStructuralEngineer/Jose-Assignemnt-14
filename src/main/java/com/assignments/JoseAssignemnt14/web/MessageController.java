package com.assignments.JoseAssignemnt14.web;


import com.assignments.JoseAssignemnt14.domain.Message;
import com.assignments.JoseAssignemnt14.domain.User;
import com.assignments.JoseAssignemnt14.service.ChannelServices;
import com.assignments.JoseAssignemnt14.service.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageServices messageServices;

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message){
        System.out.println(message);
        if(message.getMessageDate()==null){
            LocalDateTime loc = LocalDateTime.now();
            message.setMessageDate(loc);
        }
        return messageServices.saveMessage(message);
    }

    @GetMapping("/message/{channelId}")
    public List<Message> getMessages(@PathVariable Long channelId){
        List<Message> messages = messageServices.findByChannelId(channelId);
        return messages;
    }


}
