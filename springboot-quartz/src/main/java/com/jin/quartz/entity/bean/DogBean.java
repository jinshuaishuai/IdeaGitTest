package com.jin.quartz.entity.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author shuai.jin
 * @date 2021/3/3 13:57
 */
@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
@Setter
@Getter
public class DogBean {

    @Value(value = "yello")
    private String name;

    @Value(value = "23")
    private Integer age;

}
