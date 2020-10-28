package com.jin.mapper;

import com.jin.entity.domain.DoubleEleDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author shuai.jin
 * @date 2020/10/26 18:22
 */

@Mapper
@Repository
public interface DoubleEleMapper {


    void addData(DoubleEleDo eleDo);
}
