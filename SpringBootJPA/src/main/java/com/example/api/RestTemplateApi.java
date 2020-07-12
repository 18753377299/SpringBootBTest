package com.example.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestTemplateApi {
	
	@Autowired
	RestTemplate simpleRestTemplate;
	@Autowired
	RestTemplate restTemplate;
	
	/*HttpCilent：使用示例*/
	@RequestMapping("/testHttpClient")
    public Object getUser(String msg) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:15021/test/hello");
        CloseableHttpResponse response = closeableHttpClient.execute(get);
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }
	
	/*RestTemplate：*/
	@RequestMapping("/testRestTemplate")
    public Object testRestTemplate() throws IOException {
//		http://localhost:15021/test/queryUser
        ResponseEntity result= restTemplate.getForEntity("http://localhost:15021/test/hello",ResponseEntity.class);
        return result.getBody();
    }
	@RequestMapping("/sayhello")
	public String sayHello() {
	    ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:15021/test/hello", String.class, "张三");
	    return responseEntity.getBody();
	}
	@RequestMapping("/sayhello2")
	public String sayHello2() {
	    Map<String, String> map = new HashMap<>();
	    map.put("name", "李四");
	    ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={name}", String.class, map);
	    return responseEntity.getBody();
	}
//	getForObject
//	@RequestMapping("/book2")
//	public Book book2() {
//	    Book book = restTemplate.getForObject("http://HELLO-SERVICE/getbook1", Book.class);
//	    return book;
//	}
	
//	postForEntity
//	@RequestMapping("/book3")
//	public Book book3() {
//	    Book book = new Book();
//	    book.setName("红楼梦");
//	    ResponseEntity<Book> responseEntity = restTemplate.postForEntity("http://HELLO-SERVICE/getbook2", book, Book.class);
//	    return responseEntity.getBody();
//	}
	
//	postForObject
//	postForLocation
	
	
	
	
	
	
	
}
