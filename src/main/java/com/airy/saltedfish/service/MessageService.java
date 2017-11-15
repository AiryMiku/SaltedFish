package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.properties.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Airy on 2017/11/15
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message findOneById(Integer id) {
        return messageRepository.findOne(id);
    }

}
