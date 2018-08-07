package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.User;

/**
 * Created by Airy on 2018/8/7
 */

public interface UserService {

    boolean login(User user);

    User register(User user);

    User update(User user);

    User findById(Integer id);
}