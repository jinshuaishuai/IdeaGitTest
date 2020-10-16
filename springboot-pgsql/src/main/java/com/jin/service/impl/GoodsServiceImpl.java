package com.jin.service.impl;

import com.jin.entity.ao.GoodsAo;
import com.jin.entity.domain.GoodsDo;
import com.jin.mapper.GoodsMapper;
import com.jin.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuai.jin
 * @date 2020/9/17 15:03
 */
@Service
@Slf4j
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void addGoods(GoodsAo goodsAo) {

        GoodsDo goodsDo = new GoodsDo();
        BeanUtils.copyProperties(goodsAo, goodsDo);
        log.info("goodsDo的值为：------>{}", goodsDo);
        goodsMapper.addGoods(goodsDo);
    }
}
