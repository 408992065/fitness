package com.stx.entity;

public class ShowCoach {
	private int coachid;
	private String name;
	private int	age ;
	private int	gender ;
	private double hight; 
	private double weight;
	private String	url ;
	private String description;
	
	
	public ShowCoach(int coachid, String name, int age, int gender, String url) {
		this.coachid = coachid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.url = url;
	}
	public ShowCoach() {

	}
	public ShowCoach(int coachid, String name, int age, int gender, double hight, double weight, String url,
			String description) {
		this.coachid = coachid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.hight = hight;
		this.weight = weight;
		this.url = url;
		this.description = description;
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
	public double getHight() {
		return hight;
	}
	public void setHight(double hight) {
		this.hight = hight;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
