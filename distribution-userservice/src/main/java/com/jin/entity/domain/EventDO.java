package com.jin.entity.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuai.jin
 * @date 2020/6/20 18:14
 */
@Data
public class EventDO implements Serializable {

    private static final long serialVersionUID = -3691106047130050827L;

    private Integer id;

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
