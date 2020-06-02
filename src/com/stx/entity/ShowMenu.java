package com.stx.entity;

public class ShowMenu {
	private int rcollectid;
	private int recipesid;
	private String name;
	private int calorie;
	private String needfood;
	private String description1;
	private String url;
	private String ctime;


	public ShowMenu(int recipesid, String name, int calorie, String needfood, String url) {
		this.recipesid = recipesid;
		this.name = name;
		this.calorie = calorie;
		this.needfood = needfood;
		this.url = url;
	}

	public ShowMenu(int rcollectid, int  recipesid,String name, int calorie, String needfood, String description1, String url,
			String ctime) {
		this.recipesid= recipesid;
		this.rcollectid = rcollectid;
		this.name = name;
		this.calorie = calorie;
		this.needfood = needfood;
		this.description1 = description1;
		this.url = url;
		this.ctime = ctime;
	}

	public ShowMenu() {
	
	}

	public ShowMenu(int rcollectid, String name, int calorie, String needfood, String description1, String url) {
		this.rcollectid = rcollectid;
		this.name = name;
		this.calorie = calorie;
		this.needfood = needfood;
		this.description1 = description1;
		this.url = url;
	}

	public int getRecipesid() {
		return recipesid;
	}

	public void setRecipesid(int recipesid) {
		this.recipesid = recipesid;
	}

	public int getRcollectid() {
		return rcollectid;
	}
	

	public void setRcollectid(int rcollectid) {
		this.rcollectid = rcollectid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public String getNeedfood() {
		return needfood;
	}

	public void setNeedfood(String needfood) {
		this.needfood = needfood;
	}

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

}
