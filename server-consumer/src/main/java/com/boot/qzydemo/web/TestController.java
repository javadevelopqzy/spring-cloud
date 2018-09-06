package com.boot.qzydemo.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test-consumer")
    public String test() {
        // 调用对应服务
        ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity("http://server-provider-1/test", JSONObject.class);
        System.out.println(forEntity.getBody());
        return "SUCCESS";
    }
}
