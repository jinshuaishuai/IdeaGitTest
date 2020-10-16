package com.effective;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shuai.jin
 * @date 2020/10/13 9:55
 */
public class Services {

    private Services() {

    }

    //全局成员变量，利用ConcurrentHashMap,保证了线程的安全性。

    private static final Map<String,Provider> providers = new ConcurrentHashMap<>();


    //定义了一个全局的，成员变量常量。
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    //采用静态工厂方法的方式，明确方法的功能。
    public static void registerDefault(Provider provider) {
        //复用register方法，很好
       register(DEFAULT_PROVIDER_NAME, provider);
    }

    public static void register(String name, Provider provider) {
        providers.put(name, provider);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider provider = providers.get(name);
        if(provider == null) {
            throw new IllegalArgumentException("No registered provicer name " + name);
        }
        return provider.newService();
    }

}
