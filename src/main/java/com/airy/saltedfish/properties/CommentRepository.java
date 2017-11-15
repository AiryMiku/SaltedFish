package com.airy.saltedfish.properties;

import com.airy.saltedfish.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Created by Airy on 2017/11/15
 */

public interface CommentRepository extends JpaRepository<Comment,Integer>{

    /**
     * 通过id查询
     * @param id
     * @return
     */
    List<Comment> findAllById(Integer id);

}
