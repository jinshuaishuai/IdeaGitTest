package com.jin.config.lock.distributelock;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/4/20 16:50
 */
@Slf4j
public class ZookeeperDistributeLock extends AbstractDistributeLock {
    /**
     * zookeeper客户端所在地址
     */

    private final static String CONNECT_URL = "127.0.0.1:2181";

    private final String lockPath = "/lockPath";

    private ZkClient zkClient = new ZkClient(CONNECT_URL);

    private CountDownLatch countDownLatch = null;


    @Override
    protected void waitLock() {
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if(countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }

        };

        zkClient.subscribeDataChanges(lockPath,listener);
        if(zkClient.exists(lockPath)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.wait();
            } catch (Exception e) {
                log.error("处理出现失败：------>{}", e.toString());

            }
        }
        zkClient.unsubscribeDataChanges(lockPath, listener);

    }

    @Override
    public boolean tryLock() {
        try {
            zkClient.createEphemeral(lockPath);
            return true;
        } catch (Exception e) {
            log.error("获取锁失败：------>{}", e.toString());
            return false;
        }
    }

    @Override
    public void unlock() {
        if (zkClient != null) {
            zkClient.close();       //关闭锁资源
        }
    }
}
