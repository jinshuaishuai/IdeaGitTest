package com.jin.controller;

import com.jin.entity.domain.GoodsDo;
import com.jin.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:15
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class GoodInfoController {


    @Autowired
    private IGoodsService goodsService;

    @GetMapping(value = "getGoodsById")
    public ResponseEntity<GoodsDo> getGoodsById(@RequestParam("id") Integer id) {
        log.info("接口请求入参为：------>{}", id);
        GoodsDo goodsById = goodsService.getGoodsById(id);
        return ResponseEntity.ok(goodsById);
    }

}
