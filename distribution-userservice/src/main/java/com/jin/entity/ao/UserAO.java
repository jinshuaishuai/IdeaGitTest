package com.jin.entity.ao;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @NotNull(message = "年龄不能为空")
    @Min(value = 0)
    @Max(value = 160)
    private Integer age;
}
