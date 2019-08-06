package com.boot.qzydemo.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class TestController {

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private DiscoveryClient discoveryClient;

	@RequestMapping("/test-consumer")
	public String test() {
		// 调用对应服务
		ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity("http://server-provider-1/test", JSONObject.class);
		System.out.println(forEntity.getBody());
		return "SUCCESS";
	}

	/**
	 * 查看服务列表
	 *
	 * @return
	 */
	@RequestMapping("/service-list")
	public String serviceList() {
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			List<ServiceInstance> instances = discoveryClient.getInstances(service);
			for (ServiceInstance instance : instances) {
				System.out.println(instance.getMetadata());
				System.out.println(instance.getUri());
			}
		}
		return discoveryClient.description();
	}
}
