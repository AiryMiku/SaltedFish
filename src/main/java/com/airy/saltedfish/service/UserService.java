package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.User;
import com.airy.saltedfish.properties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Airy on 4/2/2018
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean vaild(User user){
        if (userRepository.findUserByUserNameAndPwd(user.getUserName(),user.getPwd()) != null) {
            return true;
        }
        return false;
    }
}
