package com.jin.mq.listener;

import com.google.gson.Gson;
import com.jin.entity.bo.PointBO;
import com.jin.mapper.UserMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author shuai.jin
 * @date 2020/6/22 5:12
 */
@Slf4j
public class UserIdTopicActiveMqListener implements MessageListener {

    @Autowired
    private UserMapper userMapper;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        String messageText = textMessage.getText();
        log.info("messageText的值为：------>{}", messageText);
        Gson gson = new Gson();
        PointBO pointBo = gson.fromJson(messageText, PointBO.class);
        int userId = pointBo.getUserId();
        userMapper.deleteUserById(userId);
    }
}
