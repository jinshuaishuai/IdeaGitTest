package com.jin.entity.ao;

import com.jin.paramvalid.config.annotation.Age;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author shuai.jin
 * @date 2020/6/20 7:53
 */
@Data
public class UserAO {

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Age(message = "年龄取值范围0-160")
    private Integer age;
}
