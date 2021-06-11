package com.boot.qzydemo.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ExternalController {

	@Resource
	RestTemplate restTemplate;

	@RequestMapping("/consumer")
	public String consumer() {
		// 调用对应服务
		ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity("http://server-consumer-1/internal-server", JSONObject.class);
		System.out.println(forEntity.getBody());
		return "SUCCESS";
	}
}
