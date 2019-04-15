package com.example.rest.demo1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		String result = restTemplate.getForObject(url, String.class);
		System.out.println(result);
		Assert.assertTrue(result != null);
	}

	@Test
	public void testPost(){
		String url = "http://localhost:8080/demo/post";
		MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.add("name", "restTemplate");
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> result = restTemplate.postForObject(url, request, Map.class);

		System.out.println(result);
		Assert.assertTrue(result != null);
	}

	@Test
	public void testPostEntity(){
		String url = "http://localhost:8080/demo/post";
		MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.add("name", "restTemplate");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

		System.out.println("http code:" + response.getStatusCode());
		System.out.println("http body:" + response.getBody());

		Assert.assertTrue(response.getStatusCode() == HttpStatus.OK);
	}

}
