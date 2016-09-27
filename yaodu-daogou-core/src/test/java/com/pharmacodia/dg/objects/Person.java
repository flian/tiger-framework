
package com.pharmacodia.dg.objects;

import java.util.List;

/**
 * @author charles(mailto:charles.wang0@pactera.com)
 *
 */
public class Person{
	
	private int age;
	private String name;
	private List<String> friends;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	

}
