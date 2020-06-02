package com.stx.entity;

public class RecommendCoach {
	private int coachid;
	private String name;
	private int	age ;
	private int	gender ;
	private String	url ;
	private int count;
	
	
	public RecommendCoach(int coachid, String name, int age, int gender, String url, int count) {
		this.coachid = coachid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.url = url;
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
