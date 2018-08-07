package com.airy.saltedfish.controller;

import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.properties.MessageRepository;
import com.airy.saltedfish.service.MessageService;
import com.airy.saltedfish.utils.ResultUtil;
import com.airy.saltedfish.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Airy on 2017/11/13
 */
@RestController
@RequestMapping("/saltedfish/api/message")
public class MessageController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    /**
     * 获取message列表
     * @return
     */
    @GetMapping(value = "/")
    public List<Message> getMessageList(){
        LOGGER.info("messageList");
        return messageRepository.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public Result getMessagesByUid(@PathVariable(name = "uid")Integer id){
        return ResultUtil.success(messageRepository.findAllByUser(id));
    }

    /**
     * 插入一条message
     * @param message
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/")
    public Result addMessage(@RequestHeader String token,@Valid Message message,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }


        return ResultUtil.error(1,"插入消息错误");
    }

    /**
     * 通过id查询message
     * @param id
     * @param bindingResult
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result messageFindById(@PathVariable("id") Integer id,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        Message message = messageRepository.findById(id);
        if (message != null){
            return ResultUtil.success(message);
        } else {
            return ResultUtil.error(1,"Unknow error");
        }

    }



}
