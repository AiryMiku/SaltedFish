package com.airy.saltedfish.service.impl;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.properties.CommentRepository;
import com.airy.saltedfish.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Airy on 2018/6/23
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Object updateComment(Comment comment){
        return commentRepository.save(comment);
    }
}
