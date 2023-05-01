package com.assignments.JoseAssignemnt14.web;

import com.assignments.JoseAssignemnt14.domain.Channel;
import com.assignments.JoseAssignemnt14.domain.Message;
import com.assignments.JoseAssignemnt14.repository.MessageRepository;
import com.assignments.JoseAssignemnt14.service.ChannelServices;
import com.assignments.JoseAssignemnt14.service.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ChannelController {

    @Autowired
    private ChannelServices channelServices;

    @Autowired
    private MessageServices messageServices;


    @GetMapping("/")
    public RedirectView redirect(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/welcome");
        return redirectView;
    }

    @GetMapping("/welcome")
    public String welcomeView(ModelMap model){

        List<Channel> channels = channelServices.findAll();

        if(channels.size()==0){
            Channel firstChannel = new Channel();
            firstChannel.setChannelName("Channel 1");
            channelServices.saveChannel(firstChannel);
            channels = channelServices.findAll();
        }

        model.put("channels",channels);

        return "welcome";
    }

    @GetMapping("/channels/{channelId}")
    public String getChannel(ModelMap model, @PathVariable Long channelId){

        List<Message> messages = messageServices.findByChannelId(channelId);

        Channel channel = channelServices.findById(channelId);
        model.put("channel",channel);
        model.put("messages",messages);

        return "channel";
    }


}
