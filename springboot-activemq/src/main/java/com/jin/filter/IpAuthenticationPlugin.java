package com.jin.filter;


import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.advisory.AdvisoryBroker;
import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author likui
 */
@Slf4j
public class IpAuthenticationPlugin implements BrokerPlugin {

    @Override
    public Broker installPlugin(Broker broker) throws Exception {
        log.info("是否有数据加载");
        return new IpAuthenticationBroker(broker);
    }

}
