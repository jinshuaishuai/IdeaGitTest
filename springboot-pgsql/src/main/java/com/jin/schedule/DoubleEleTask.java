package com.jin.schedule;

import com.jin.entity.domain.DoubleEleDo;
import com.jin.mapper.DoubleEleMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author shuai.jin
 * @date 2020/10/26 18:25
 */
@Component
public class DoubleEleTask {

    /*@Autowired
    private DoubleEleMapper doubleEleMapper;

    @Scheduled(cron = "0/5 * * * * *")
    public void save() {
        DoubleEleDo eleDo = DoubleEleDo.builder()
                .age(23)
                .createTime(new Date())
                .updateTime(new Date())
                .isDelete(0)
                .name("张三")
                .phone(UUID.randomUUID().toString())
                .shopName(UUID.randomUUID().toString())
                .status(1)
                .type(2)
                .build();
        doubleEleMapper.addData(eleDo);
    }*/
}
