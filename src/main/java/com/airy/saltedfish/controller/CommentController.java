package com.airy.saltedfish.controller;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.properties.CommentRepository;
import com.airy.saltedfish.properties.MessageRepository;
import com.airy.saltedfish.utils.DateUtil;
import com.airy.saltedfish.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Airy on 2017/11/15
 */
@RestController
@RequestMapping("/saltedfish/api")
public class CommentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 查询所有 comment
     * @return
     */
    @GetMapping(value = "/comment")
    public List<Comment> getCommentList(){
        return commentRepository.findAll();
    }

}
