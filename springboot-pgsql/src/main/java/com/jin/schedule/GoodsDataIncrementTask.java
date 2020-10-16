package com.jin.schedule;

import com.jin.entity.ao.GoodsAo;
import com.jin.service.IGoodsService;
import com.jin.service.impl.GoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

/**
 * @author shuai.jin
 * @date 2020/9/17 15:01
 */
@Component
@Slf4j
public class GoodsDataIncrementTask {

    /**
     * 该案例用于演示大数据量下索引的分类，索引方法BTree,Hash,索引失效，
     * 聚簇索引等一系列问题
     */

    @Autowired
    private IGoodsService goodsService;

    Random random = new Random();

    private String[] goodsNames = {"basketball", "pingpangball",
            "football", "T-Shits",
    "Inflatable doll","banana"};

    private String[] colors = {"red", "yellow", "blue"};

    private String[] spus = {"aaa", "bbb", "ccc", "ddd"};

//    @Scheduled(cron = "0/1 * * * * *")
    public void incrementData2Goods() {

        for(int i = 0; i < 10000; i++) {
            String goodsName =
                    goodsNames[new Double(Math.random() * goodsNames.length).intValue()];
            GoodsAo goodsAo = GoodsAo.builder()
                    .goodsName(goodsName)
                    .color(colors[new Double(Math.random() * colors.length).intValue()])
                    .goodsPrice(new BigDecimal(Math.random() * 1000))
                    .goodsQuantity(new Double(Math.random() * 100).intValue())
                    .goodsSku(UUID.randomUUID().toString())
                    .goodsSpu(spus[new Double(Math.random() * spus.length).intValue()]).build();

            goodsService.addGoods(goodsAo);
        }

    }

}
