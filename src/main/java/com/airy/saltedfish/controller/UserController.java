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
import java.util.Map;

/**
 * Created by Airy on 2017/12/18
 */
@RestController
@RequestMapping("/saltedfish/api")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/find")
    public User getUserByUserName(@RequestBody Map<String,Object> reqMap){
        String name = reqMap.get("name").toString();
        LOGGER.info("messageList");
        return userRepository.findByUserName(name);
    }

    /***
     * 用户注册
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/user/register")
    @ResponseBody
    public Result register(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        if (userRepository.findByUserName(user.getUserName()) !=null) {
            return ResultUtil.error(1,"User is exist");
        }
        user.setUserName(user.getUserName());
        user.setPwd(user.getPwd());

        return ResultUtil.success(userRepository.save(user));
    }

    /***
     * 用户登陆
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/user/login")
    public Result login(@Valid User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        if (userService.vaild(user)) {
            return ResultUtil.success();
        }
        return ResultUtil.error(1,"wrongPwd or userName");

    }

}
