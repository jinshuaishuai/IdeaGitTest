package com.jin.entity.dto;

import com.jin.entity.domain.PointDO;
import com.jin.entity.domain.UserDO;
import lombok.Data;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/22 11:57
 */
@Data
public class UserPointDTO {

    private UserDO userDo;

    private List<PointDO> pointDoList;

}
