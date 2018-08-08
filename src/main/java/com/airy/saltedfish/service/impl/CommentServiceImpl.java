package com.airy.saltedfish.service.impl;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Page;
import com.airy.saltedfish.properties.CommentRepository;
import com.airy.saltedfish.properties.MessageRepository;
import com.airy.saltedfish.properties.PageRepository;
import com.airy.saltedfish.service.CommentService;
import com.airy.saltedfish.utils.DateUtil;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Airy on 2018/6/23
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private PageRepository pageRepository;


    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Integer id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Page addToPage(Integer pid,Comment comment) {
        Page page = pageRepository.findOne(pid);
//        page.addComment(comment);
        return pageRepository.save(page);
    }

    @Override
    public Message addToMessage(Integer mid,Comment comment) {
        comment.setDate(DateUtil.getDate());
        commentRepository.save(comment);
        Message message = messageRepository.findOne(mid);
        message.addComment(comment);
        return messageRepository.save(message);
    }

    @Override
    public void delete(Integer id) {
        commentRepository.delete(id);
    }

    @Override
    public void update(Comment comment) {

    }
}
