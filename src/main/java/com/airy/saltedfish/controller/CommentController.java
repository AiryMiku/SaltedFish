package com.airy.saltedfish.controller;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.properties.CommentRepository;
import com.airy.saltedfish.service.impl.CommentServiceImpl;
import com.airy.saltedfish.service.impl.MessageServiceImpl;
import com.airy.saltedfish.utils.DateUtil;
import com.airy.saltedfish.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Airy on 2017/11/15
 */
@RestController
@RequestMapping("/saltedfish/api/comment")
public class CommentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CommentController.class);


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    /**
     * 查询所有 comment
     * @return
     */
    @GetMapping(value = "/")
    public List<Comment> getCommentList(){
        return commentRepository.findAll();
    }

    /**
     * 根据messageId插入一条comment
     * @param id
     * @param nickName
     * @param content
     * @return
     */
    @PostMapping(value = "message/{id}/")
    public Result addOneCommentToMessage(@PathVariable("id") Integer id,
                                         @RequestParam("nickName") String nickName,
                                         @RequestParam("content") String content){


        Message message = messageServiceImpl.findOneById(id);
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setDate(DateUtil.getDate());
        message.addComment(comment);
        commentServiceImpl.updateComment(comment);

        return ResultUtil.success(messageServiceImpl.updateMessage(message));


    }

}
