package com.boot.qzydemo;

import com.alibaba.fastjson.JSONObject;
import com.boot.qzydemo.web.TestController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class QzydemoApplicationTests {

	// 模拟进行一次调用
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON));
		perform.andExpect(MockMvcResultMatchers.status().isOk());
		JSONObject json = new JSONObject();
		json.put("name","1111");
		ResultActions resultAction = perform.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo(JSONObject.toJSONString(json))));
		MockHttpServletResponse response = resultAction.andReturn().getResponse();
		System.out.println(response);

	}
}
