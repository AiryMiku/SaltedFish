package com.airy.saltedfish.service.impl;

import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.properties.MessageRepository;
import com.airy.saltedfish.service.MessageService;
import com.airy.saltedfish.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Airy on 2017/11/15
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> findAllByUid(Integer uid) {
        return messageRepository.findAllByUser(uid);
    }

    @Override
    public Message findById(Integer id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message add(Message message) {
        message.setDate(DateUtil.getDate());
        return messageRepository.save(message);
    }

    @Override
    public void delete(Integer id) {
        messageRepository.delete(id);
    }

    @Override
    public Message update(Message message) {
        return messageRepository.save(message);
    }

    public Message findOneById(Integer id) {
        return messageRepository.findOne(id);
    }

    public Object updateMessage(Message message){
        return messageRepository.save(message);
    }
}
