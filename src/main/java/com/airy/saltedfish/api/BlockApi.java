package com.airy.saltedfish.api;

import com.airy.saltedfish.domain.Block;
import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.service.BlockService;
import com.airy.saltedfish.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Airy on 2018/8/7
 */
@RestController
@RequestMapping("/saltedfish/api/block")
public class BlockApi {

    private final static Logger LOGGER = LoggerFactory.getLogger(BlockApi.class);

    @Autowired
    private BlockService blockService;

    /**
     * 查询所有 block
     * @return
     */
    @GetMapping(value = "/")
    public Result getAllBlock(){
        return ResultUtil.success(blockService.findAll());
    }

    @PostMapping(value = "/")
    public Result addBlock(@RequestParam(name = "name") String name){
        Block block = new Block();
        block.setName(name);
        return ResultUtil.success(blockService.add(block));
    }

    @DeleteMapping(value = "/")
    public Result delBlock(@RequestParam(name = "id") Integer id){
        blockService.delete(id);
        return ResultUtil.result("block 删除成功");
    }
}
