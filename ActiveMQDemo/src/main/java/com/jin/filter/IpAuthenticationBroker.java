package com.jin.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.command.ConnectionInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class IpAuthenticationBroker extends BrokerFilter {

    Pattern pattern = Pattern.compile("^([0-9\\.]*):(.*)");

    public IpAuthenticationBroker(Broker next ){
        super(next);
    }

    public String getSubAddress(String remoteAddress) {
        String subAddress = null;
        for (int i = 0; i < remoteAddress.length(); i++) {
            char ch = remoteAddress.charAt(i);
            if (ch >= '0' && ch <= '9') {
                subAddress = remoteAddress.substring(i);
                break;
            }
        }
        return subAddress;
    }

    @Override
    public void addConnection(ConnectionContext context, ConnectionInfo info) throws Exception {

        //获取连接者的IP,格式为:tcp://127.0.0.1:6572
        String remoteAddress = context.getConnection().getRemoteAddress();
        //获取允许访问的IP列表
        String ips = getAllowedIPAddressesByDb();

        Matcher matcher = pattern.matcher(getSubAddress(remoteAddress));
        boolean findIP = false;
        if (matcher.matches()) {
            String ip = matcher.group(1);
            String[] ipList= ips.split(",");
            for (String s : ipList) {
                if (s.equals(ip)) {
                    findIP = true;
                    break;
                }
            }

            if(!findIP){
                throw new SecurityException("Connecting from IP address " + ip + " is not allowed" );
            }

        } else {
            throw new SecurityException("Invalid remote address " + remoteAddress + "subAddress " + getSubAddress(remoteAddress));
        }
        super.addConnection(context, info);
    }

    /**
     * 读取允许访问的IP列表
     * @return String 读取到的IP列表，逗号分隔，如果访问出现异常，返回空字符串
     */
    public String getAllowedIPAddressesByDb(){

        String ipStr = "";

        try {

            String setting = "";
//            setting = Util.getConfigFromCenter("BIG_DATA","data_streaming","data_streaming_online","ActiveMqAccessIpList");
            if(setting == null){
                return ipStr = "1";
            }else{
//                ipStr = setting.getReservedFields3();
                ipStr = "192.168.192.134,192.168.192.133";
            }

        } catch (Exception e) {
            return "2";
        }
        return ipStr;

    }

}
