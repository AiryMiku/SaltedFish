package com.airy.saltedfish.controller;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.properties.CommentRepository;
import com.airy.saltedfish.properties.MessageRepository;
import com.airy.saltedfish.service.MessageService;
import com.airy.saltedfish.utils.DateUtil;
import com.airy.saltedfish.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by Airy on 2017/11/13
 */
@RestController
@RequestMapping("/saltedfish/api")
public class MessageController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 获取message列表
     * @return
     */
    @GetMapping(value = "/message")
    public List<Message> getMessageList(){
        LOGGER.info("messageList");
        return messageRepository.findAll();
    }

    /**
     * 插入一条message
     * @param message
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/message")
    public Result<Message> addMessage(@Valid Message message,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        message.setNickName(message.getNickName());
        message.setContent(message.getContent());
        message.setDisLikeNum(0);
        message.setLikeNum(0);

        return ResultUtil.success(messageRepository.save(message));
    }

    /**
     * 通过id查询message
     * @param id
     * @param bindingResult
     * @return
     */
    @GetMapping(value = "/message/{id}")
    public Result<Message> messageFindById(@PathVariable("id") Integer id,
                                           BindingResult bindingResult) {

//        List list = messageRepository.findAllById(id);
//        if (list != null){
//            return ResultUtil.success(list);
//        } else {
//            return ResultUtil.error(1,"")
//        }

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        } else {
            return ResultUtil.success(messageRepository.findAllById(id));
        }
    }

    /**
     * 根据messageId插入一条comment
     * @param id
     * @param nickName
     * @param content
     * @return
     */
    @PostMapping(value = "message/{id}/comment")
    public Result<Message> addOneCommentToMessage(@PathVariable("id") Integer id,
                                                  @RequestParam("nickName") String nickName,
                                                  @RequestParam("content") String content){


            Message message = messageService.findOneById(id);
            Comment comment = new Comment();
            comment.setNickName(nickName);
            comment.setCotent(content);
            comment.setDate(DateUtil.getDate());
            message.addComment(comment);
            commentRepository.save(comment);

            return ResultUtil.success(messageRepository.save(message));


    }

}
