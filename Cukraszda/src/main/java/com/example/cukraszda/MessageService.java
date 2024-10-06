package com.example.cukraszda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private com.example.cukraszda.messageRepo messageRepo;

    public List<MessageDTO> getAllMessages() {
        return messageRepo.findAllMessagesWithDetails();
    }
}
