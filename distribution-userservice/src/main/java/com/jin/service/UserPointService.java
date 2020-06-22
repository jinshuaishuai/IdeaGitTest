package com.jin.service;

import com.jin.entity.domain.PointDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/22 13:43
 */
@FeignClient(name = "pointservice")
public interface UserPointService {
    /**
     * 获取用户列表接口
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/userpoint/getUserPointList")
    List<PointDO> getUserPoint(@RequestParam(value = "userId") int userId);
}
