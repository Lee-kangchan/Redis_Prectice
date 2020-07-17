package com.redis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.redis.app.SpringRedisConfig;
import com.redis.app.vo.Employee;

@Service
public class SpringRedisExample {
	public void exam() {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
		try {
			@SuppressWarnings("unchecked")
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>)ctx.getBean("redisTemplate");
			// value operation
			ValueOperations<String, Object> values = redisTemplate.opsForValue();
			
			// set
			values.set("victolee", new Employee("01", "victolee"));
			
			// get
			System.out.println("Employee added : " + values.get("victolee"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ctx.close();
		}
		
		
	}
	public void exam1() {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
		try {
			@SuppressWarnings("unchecked")
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>)ctx.getBean("redisTemplate");
			
			Map<String, String> empBobMap = new HashMap<String, String>();
			empBobMap.put("name", "Bob");
			empBobMap.put("age", "26");
			empBobMap.put("id", "02");
			
			Map<String, String> empJohnMap = new HashMap<String ,String>();
			empJohnMap.put("name", "John");
			empJohnMap.put("age", "16");
			empJohnMap.put("id", "03");
			
			// Hash Operation
			HashOperations<String, String, String> hash = redisTemplate.opsForHash();
			String empBobKey = "emp:Bob";
			String empJohnKey = "emp:John";
			
			hash.putAll(empBobKey, empBobMap);
			hash.putAll(empJohnKey, empJohnMap);
			
			System.out.println("Get emp Bob : " + hash.entries(empBobKey));
			System.out.println("Get emp John : " + hash.entries(empJohnKey));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ctx.close();
		}
		
	}
	public void string(String no , String name, String age ) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
		try {
			@SuppressWarnings("unchecked")
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>)ctx.getBean("redisTemplate");
			
			Map<String, String> people = new HashMap<String, String>();
			people.put("name", name);
			people.put("age", age);
			
			HashOperations<String, String, String> hash = redisTemplate.opsForHash();
			String no1 = no;
			
			
			hash.putAll(no1, people);
			
			System.out.println(no+ ": " + hash.entries(no1));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ctx.close();
		}
		
	}
	public void list() {
		
	}
	public void sort() {
		
	}
	public void set() {
		
	}
}