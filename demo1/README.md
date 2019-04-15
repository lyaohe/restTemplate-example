## 第一节：最简单的get/post请求

### 创建Get接口和Post接口

为了验证RestTemplate的使用姿势，当然得先提供一个后端的REST服务，写2个简单的接口来测试

    @RestController
    @RequestMapping("/demo")
    public class demoController {
    
        @GetMapping("/get")
        public String get(){
            return "hello world";
        }
    
        @PostMapping("/post")
        public Map<String, Object> post(String name){
            Map<String, Object> res = new HashMap<>();
            res.put("id", 1);
            res.put("method", "post");
            res.put("name", name);
            return res;
        }
    
    }
    
然后开始写RestTemplate接口测试

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
    
本节，我们用 getForObject，postForObject，最简单的接口来入门 RestTemplate；

如果你们需要拿到http状态码，可以使用 getForEntity、postForEntity 接口；

最后，你们会不会，总是 new RestTemplate 很不规范，下一节，我们来搭建一个规范的工程架子。