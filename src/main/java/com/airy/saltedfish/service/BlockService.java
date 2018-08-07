package com.airy.saltedfish.service;

import com.airy.saltedfish.domain.Block;

import java.util.List;

/**
 * Created by Airy on 2018/8/7
 */

public interface BlockService {

    Block findByID(Integer id);

    List<Block> findAll();

    Block add(Block block);

    void delete(Integer id);

    Block update(Block block);

}
