package com.airy.saltedfish.controller;

import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.domain.User;
import com.airy.saltedfish.properties.UserRepository;
import com.airy.saltedfish.service.UserService;
import com.airy.saltedfish.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Airy on 2017/12/18
 */
@RestController
@RequestMapping("/saltedfish/api/user")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 通过id返回用户信息
     * @param id
     * @return
     */
    @PostMapping(value = "/find/{id}")
    public Result getUserByUserName(@PathVariable("id") Integer id){
        return ResultUtil.success(userService.findById(id));
    }

    /***
     * 用户注册
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public Result register(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        if (userRepository.findByUserName(user.getUserName()) !=null) {
            return ResultUtil.error(1,"User is exist");
        }

        return ResultUtil.success(userService.register(user));
    }

    /***
     * 用户登陆
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/login")
    public Result login(@Valid User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        if (userService.login(user)) {
            return ResultUtil.success();
        }
        return ResultUtil.error(1,"wrongPwd or userName");

    }

}
