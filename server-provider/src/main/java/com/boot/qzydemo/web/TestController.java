package com.boot.qzydemo.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        JSONObject json = new JSONObject();
        json.put("name","1111");
        return JSON.toJSONString(json);
    }

}
