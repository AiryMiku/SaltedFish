package com.airy.saltedfish.service.impl;

import com.airy.saltedfish.domain.User;
import com.airy.saltedfish.properties.UserRepository;
import com.airy.saltedfish.service.UserService;
import com.airy.saltedfish.utils.DateUtil;
import com.airy.saltedfish.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * Created by Airy on 4/2/2018
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean login(User user) {
        if (userRepository.findUserByUserNameAndPwd(user.getUserName(),user.getPwd()) != null) {
            return true;
        }
        return false;
    }

    public User register(User user) {
        user.setCreateDate(DateUtil.getDate());
        userRepository.save(user);
        try {
            user.setToken(TokenUtil.createToken(user.getId()));
            return userRepository.save(user);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

}
