package com.jin.entity.DO;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @date 2020/3/8 15:10
 * @Author lenovo
 */
@Entity
@Table(name = "book")
@Data
public class BookDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "book_name", nullable = false, columnDefinition = "varchar(64) default '' comment '图书名称'")
    private String bookName;

    @Column(name = "book_price",nullable = false, columnDefinition = "decimal(19,2) default 0 comment '图书价格'")
    private BigDecimal bookPrice;

    private String address;

    private String phone;

    @Column(name = "is_delete", nullable = false, columnDefinition = "tinyint(2) default 0")
    private Integer isDelete;

    @CreatedDate
    @Column(name = "create_time")
    private String createTime;

    @LastModifiedDate
    @Column(name = "update_time")
    private String updateTime;

}
