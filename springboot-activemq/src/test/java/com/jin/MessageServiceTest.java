package com.jin;

import com.jin.config.mq.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuai.jin3
 * @description TODO
 * @Date 2020/5/25 13:41
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageServiceTest {

    @Autowired
    MessageService messageService;
    @Test
    public void testMessageSend() {

        System.out.println(messageService);
        messageService.sendMessage("不见了远处的青山");
    }
}
