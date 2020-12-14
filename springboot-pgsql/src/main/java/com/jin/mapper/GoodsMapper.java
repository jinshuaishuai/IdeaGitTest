package com.jin.mapper;

import com.jin.entity.domain.GoodsDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author shuai.jin
 * @date 2020/9/17 15:37
 */
@Mapper
@Repository
public interface GoodsMapper {

    void addGoods(GoodsDo goodsDo);


    GoodsDo getGoodsById(@Param("id") Integer id);
}
