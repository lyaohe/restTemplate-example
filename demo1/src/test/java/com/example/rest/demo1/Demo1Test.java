package com.example.rest.demo1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1Test {

	@Test
	public void testGet(){
		String url = "http://localhost:8080/demo/get";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> result = restTemplate.getForObject(url, Map.class);
		System.out.println(result);
		Assert.assertTrue(result != null);
	}

	@Test
	public void testPost(){
		String url = "http://localhost:8080/demo/post";
		MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.add("name", "restTemplate");
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(url, request, String.class);
		System.out.println(result);
		Assert.assertTrue(result != null);
	}

}
