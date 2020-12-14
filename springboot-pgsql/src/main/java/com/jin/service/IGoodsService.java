package com.jin.service;

import com.jin.entity.ao.GoodsAo;
import com.jin.entity.domain.GoodsDo;

/**
 * @author shuai.jin
 * @date 2020/9/17 15:03
 */

public interface IGoodsService {

    void addGoods(GoodsAo goodsAo);

    GoodsDo getGoodsById(Integer id);
}
