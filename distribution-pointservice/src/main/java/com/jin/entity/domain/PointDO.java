package com.jin.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shuai.jin
 * @date 2020/6/20 18:12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointDO implements Serializable {

    private static final long serialVersionUID = 8564904381575883395L;

    private Integer id;

    private Integer userId;

    private BigDecimal point;
}
