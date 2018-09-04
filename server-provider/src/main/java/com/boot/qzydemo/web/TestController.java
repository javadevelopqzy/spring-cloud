package com.boot.qzydemo.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class);

    @Resource
    private DiscoveryClient client;

    @RequestMapping("/test")
    public String test() {
        List<String> services = client.getServices();
        for (String service : services) {
            logger.info(service);
        }
        ServiceInstance localServiceInstance = client.getLocalServiceInstance();
        logger.info(localServiceInstance.getServiceId());
        JSONObject json = new JSONObject();
        json.put("name","1111");
        return JSON.toJSONString(json);
    }

}
