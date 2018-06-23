package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.properties.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Airy on 2018/6/23
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    

}
