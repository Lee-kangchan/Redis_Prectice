package com.redis.app.vo;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Integer age;
	
	public Employee() {}
	
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}

	// getter, setter »ý·«

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}