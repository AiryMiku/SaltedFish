package com.airy.saltedfish.api;

import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.domain.User;
import com.airy.saltedfish.domain.UserResult;
import com.airy.saltedfish.properties.UserRepository;
import com.airy.saltedfish.redis.RedisUtil;
import com.airy.saltedfish.service.UserService;
import com.airy.saltedfish.utils.ResultUtil;
import com.airy.saltedfish.utils.TokenUtil;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

/**
 * Created by Airy on 2017/12/18
 */
@RestController
@RequestMapping("/saltedfish/api/user")
public class UserApi {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

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
    public Result register(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        if (userRepository.findByUserName(user.getUserName()) !=null) {
            return ResultUtil.error(1,"User is exist");
        }
        User u = userService.register(user);
        if (u != null){
            UserResult userResult = new UserResult();
            userResult.setId(u.getId());
            userResult.setUserName(u.getUserName());
            userResult.setToken(u.getToken());
            RedisUtil redis = new RedisUtil();
//            redis.add();
            return ResultUtil.success(userResult);
        }else{
            return ResultUtil.error(1,"unknow error");
        }
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
