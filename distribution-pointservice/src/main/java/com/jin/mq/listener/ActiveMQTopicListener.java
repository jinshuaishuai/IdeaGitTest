package com.jin.mq.listener;

import com.jin.entity.domain.EventDO;
import com.jin.mapper.EventMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author shuai.jin
 * @date 2020/6/6 17:48
 */
@Slf4j
public class ActiveMQTopicListener implements MessageListener {

    @Autowired
    private EventMapper eventMapper;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        //从消息的主题中获取到积分相关的json格式的数据
        String messageText = textMessage.getText();
        log.info("从主题消息队列中获取到的消息内容为：------>{}", messageText);
        EventDO eventDo = new EventDO();
        eventDo.setProcess("PUBLISHED");
        eventDo.setType("addPoint");
        eventDo.setContent(messageText);

        eventMapper.addEvent(eventDo);
    }
}
