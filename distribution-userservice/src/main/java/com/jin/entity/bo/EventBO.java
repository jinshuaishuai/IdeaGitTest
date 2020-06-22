package com.jin.entity.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuai.jin
 * @date 2020/6/20 7:47
 */
@Data
public class EventBO implements Serializable {

    private static final long serialVersionUID = 8072771486645043360L;

    /**
     *  事件的类型 新建用户 新建积分
     */
    private String type;

    /**
     * 新建：NEW 发布：PUBLISHED 处理完成 PROCESSED
     */
    private String process;

    /**
     * json格式的数据内容
     */
    private String content;

}
