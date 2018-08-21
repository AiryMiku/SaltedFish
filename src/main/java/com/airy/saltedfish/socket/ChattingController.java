package com.airy.saltedfish.socket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by Airy on 2018/8/19
 */
@Controller
public class ChattingController {

    @MessageMapping("/chatting")
    @SendTo("/wsdata/chat") // 客户端接收路径
    public ChatMessage chatting(ChatMessage chatMessage) throws Exception{
        Thread.sleep(1000); // handler data
        return new ChatMessage(chatMessage.getName(),chatMessage.getContent());
    }

}
