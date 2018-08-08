package com.airy.saltedfish.api;

import com.airy.saltedfish.domain.Comment;
import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.properties.CommentRepository;
import com.airy.saltedfish.service.CommentService;
import com.airy.saltedfish.service.impl.CommentServiceImpl;
import com.airy.saltedfish.service.impl.MessageServiceImpl;
import com.airy.saltedfish.utils.DateUtil;
import com.airy.saltedfish.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Airy on 2017/11/15
 */
@RestController
@RequestMapping("/saltedfish/api/comment")
public class CommentApi {

    private final static Logger LOGGER = LoggerFactory.getLogger(CommentApi.class);

    @Autowired
    private CommentService commentService;


    /**
     * 查询所有 comment
     * @return
     */
    @GetMapping(value = "/")
    public Result getCommentList(){
        return ResultUtil.success(commentService.findAll());
    }

    /**
     * 根据messageId插入一条comment
     * @param mid
     * @param comment
     * @return
     */
    @PostMapping(value = "/message/")
    public Result addCommentToMessage(@Valid Integer mid,@Valid Comment comment){
        return ResultUtil.success(commentService.addToMessage(mid,comment));
    }

    /**
     * 根据PageId插入一条comment
     * @param pid
     * @param comment
     * @return
     */
    @PostMapping(value = "/page/")
    public Result addCommentToPage(@RequestAttribute Integer pid,@Valid Comment comment){
        return ResultUtil.success(commentService.addToPage(pid,comment));
    }

}
