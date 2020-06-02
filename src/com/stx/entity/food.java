package com.stx.entity;

public class food {
  private  int foodid;
  private  int kindid;
  private  String name;
  private  String calorie;
  private   String description;
  private String ctime;

    

    public food(int foodid, int kindid, String name, String calorie, String description, String ctime) {
	this.foodid = foodid;
	this.kindid = kindid;
	this.name = name;
	this.calorie = calorie;
	this.description = description;
	this.ctime = ctime;
}

	public int getKindid() {
	return kindid;
}

public void setKindid(int kindid) {
	this.kindid = kindid;
}

	public int getFoodid() {
        return foodid;
    }

    public food setFoodid(int foodid) {
        this.foodid = foodid;
        return this;
    }

    public String getName() {
        return name;
    }

    public food setName(String name) {
        this.name = name;
        return this;
    }

    public String getCalorie() {
        return calorie;
    }

    public food setCalorie(String calorie) {
        this.calorie = calorie;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public food setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public food setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }
}
