package com.airy.saltedfish.properties;

import com.airy.saltedfish.domain.Message;
import com.airy.saltedfish.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Airy on 2017/11/14
 */

public interface MessageRepository extends JpaRepository<Message,Integer> {

    /**
     * 通过id查询
      * @param id
     * @return
     */
    Message findById(Integer id);

    List<Message> findAllByUser(Integer id);

}
