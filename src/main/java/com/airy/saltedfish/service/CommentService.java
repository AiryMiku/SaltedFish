package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Page;

import java.util.List;

/**
 * Created by Airy on 2018/8/7
 */

public interface CommentService {

    List<Comment> findAll();
    Comment findById(Integer id);
    Page addToPage(Integer pid,Comment comment);
    Message addToMessage(Integer mid,Comment comment);
    void delete(Integer id);
    void update(Comment comment);
}
