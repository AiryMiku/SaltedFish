package com.airy.saltedfish.properties;

import com.airy.saltedfish.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Airy on 4/1/2018
 */

public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     *
     * @param name
     * @return
     */
    User findByUserName(String name);

    User findUserByUserNameAndPwd(String name,String pwd);

}
