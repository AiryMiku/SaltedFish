package com.airy.saltedfish.properties;

import com.airy.saltedfish.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Airy on 2018/8/7
 */

public interface BlockRepository extends JpaRepository<Block,Integer> {

}
