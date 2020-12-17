package com.jin.controller;

import com.jin.entity.ao.UserAo;
import com.jin.entity.ao.UserListAo;
import com.jin.entity.domain.UserInfoDo;
import com.jin.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:15
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "getUserInfoById")
    public UserInfoDo getUserInfoById(@RequestParam(value = "id") int id) {
        log.info("接口请求入参为：------>{}", id);
        UserInfoDo value = userInfoService.getUserInfoById(id);
        return value;
    }

    @PostMapping(value = "getUserListByParam")
    public ResponseEntity<List<UserInfoDo>> getUserListByParam(@RequestBody UserInfoDo userInfoDo) {
        log.info("接口请求入参为：------>{}", userInfoDo);
        List<UserInfoDo> result = userInfoService.getUserListByParam(userInfoDo);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "getDynamicQueryResult")
    public List<Map<String, Object>> getDynamicQueryResult() {

        List<Map<String, Object>> result = userInfoService.getDynamicQueryResult();
        return result;
    }

    @PostMapping(value = "add")
    public ResponseEntity save(@RequestBody UserAo userAo) {
        log.info("接口请求入参为：------>{}", userAo);
        userInfoService.save(userAo);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "addBatch")
    public ResponseEntity addBatch(@RequestBody UserListAo userAoList) {
        log.info("接口请求入参为：------>{}", userAoList);
        List<UserAo> userAoList1 = userAoList.getUserAoList();
        userInfoService.addBatch(userAoList1);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "update")
    public ResponseEntity update(@RequestBody UserAo userAo) {
        log.info("接口请求入参为：------>{}", userAo);
        userInfoService.update(userAo);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "delete")
    public ResponseEntity delete(@RequestBody UserAo userAo) {
        log.info("接口请求入参为：------>{}", userAo);
        userInfoService.delete(userAo);
        return ResponseEntity.ok().build();
    }
}
