package com.airy.saltedfish.service.impl;

import com.airy.saltedfish.domain.Block;
import com.airy.saltedfish.properties.BlockRepository;
import com.airy.saltedfish.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Airy on 2018/8/7
 */
@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public Block findByID(Integer id) {
        return blockRepository.findOne(id);
    }

    @Override
    public Block add(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public void delete(Integer id) {
        blockRepository.delete(id);
    }

    @Override
    public Block update(Block block) {
        return blockRepository.save(block);
    }
}
