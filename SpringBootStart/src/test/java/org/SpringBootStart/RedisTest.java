package org.SpringBootStart;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringBootStartApplication;
import com.example.po.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootStartApplication.class)
public class RedisTest {
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	//注入redisTemplate
    @Autowired
    private StringRedisTemplate  stringRedisTemplate;
    
	/**
	* 添加一个字符串
	*/
	@Test
	public void testSet(){
//		this.redisTemplate.opsForValue().set("key", "22");
		this.redisTemplate.opsForValue().set("second", "123", 30, TimeUnit.SECONDS);
	}
	/**
	* 获取一个字符串
	*/
	@Test
	public void testGet(){
		String value =(String)this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
	/*Spring Data Redis  操作实体对象*/
	/**
	* 添加 Users 对象
	*/
	@Test
	public void testSetUesrs(){
		Users users = new Users();
		users.setAge(20);
		users.setName("张三丰");
		users.setId(2);
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new  JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("users", users);
	}
	
	/**
	* 取 Users 对象
	*/
	@Test
	public void testGetUsers(){
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new
		JdkSerializationRedisSerializer());
		Users users =(Users)this.redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}
	/*Spring Data Redis  以 JSON  格式存储实体对象*/
	/**
	* 基于 JSON 格式存 Users 对象
	*/
	@Test
	public void testSetUsersUseJSON(){
		Users users = new Users();
		users.setAge(20);
		users.setName("李四丰");
		users.setId(1);
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("users_json", users);
	}
	/**
	* 基于 JSON 格式取 Users 对象
	*/
	@Test
	public void testGetUseJSON(){
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users =(Users)this.redisTemplate.opsForValue().get("users_json");
		System.out.println(users);
	}
	
	
	
}
