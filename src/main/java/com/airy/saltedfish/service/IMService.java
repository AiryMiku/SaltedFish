package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.Chat;

import java.util.List;

/**
 * 聊天
 *
 * Created by Airy on 2018/8/10
 */

public interface IMService {

    Chat getChatInfo(int chatId);

    int createChat(Chat chat);

    List<Chat> getChatsByUserId(int uid);

}
