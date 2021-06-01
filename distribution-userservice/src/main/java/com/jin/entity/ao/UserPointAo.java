package com.jin.entity.ao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shuai.jin
 * @date 2021/3/4 17:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPointAo implements Serializable {

    private Integer userId;

    private BigDecimal point;

}
