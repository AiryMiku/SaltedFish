package com.airy.saltedfish.api;

import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.service.MessageService;
import com.airy.saltedfish.utils.ResultUtil;
import com.airy.saltedfish.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Airy on 2017/11/13
 */
@RestController
@RequestMapping("/saltedfish/api/message")
public class MessageApi {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageApi.class);

    @Autowired
    private MessageService messageService;

    /**
     * 获取message列表
     * @return
     */
    @GetMapping(value = "/")
    public Result getMessageList(){
        LOGGER.info("messageList");
        return ResultUtil.success(messageService.findAll());
    }

    @GetMapping(value = "/byuid")
    public Result getMessagesByUid(@RequestParam Integer uid){
        return ResultUtil.success(messageService.findAllByUid(uid));
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

        if (TokenUtil.verifyTokenSimply(token)){
            return ResultUtil.success(messageService.add(message));
        }
        return ResultUtil.error(-1,"token error");
    }

    /**
     * 通过id查询message
     * @param id
     * @return
     */
    @GetMapping(value = "/byid")
    public Result messageFindById(@RequestParam Integer id) {

        Message message = messageService.findById(id);
        return ResultUtil.success(message);

    }



}
