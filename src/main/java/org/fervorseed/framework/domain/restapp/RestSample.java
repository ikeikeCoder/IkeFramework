package org.fervorseed.framework.domain.restapp;

public class RestSample {
	String id;
	String name;
	int age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		String str ="{";
		str  += "id = " +id + ", ";
		str  += "name = " +name + ", ";
		str  += "age = " +age;
		str += "}";
		return str;
	}
	
	
}
