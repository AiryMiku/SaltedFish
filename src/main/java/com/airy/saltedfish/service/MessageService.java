package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.Message;

import java.util.List;

/**
 * Created by Airy on 2018/8/7
 */

public interface MessageService {

    List<Message> findAll();
    List<Message> findAllByUid(Integer uid);
    Message findById(Integer id);
    Message add(Message message);
    void delete(Integer id);
    Message update(Message message);
}
