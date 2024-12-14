package com.nyc.sbpharmacy.service;


import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.Message;
import com.nyc.sbpharmacy.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void insertMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getMyMessages(AppUser appUser) {
        return messageRepository.findByReceiver(appUser);
    }
}
