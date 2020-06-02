package com.stx.entity;

public class recipes {
    private  int  recipesid;
    private String name;
    private double calorie;
    private  String needfood;
    private  String description1;
    private String ctime;

    public recipes() {

	}

	public recipes(int recipesid, String name, double  calorie, String needfood, String description1) {
        this.recipesid =recipesid;
        this.name = name;
        this.calorie = calorie;
        this.needfood = needfood;
        this.description1 = description1;
    }

    public int getRecipesid() {
        return recipesid;
    }

    public recipes setRecipesid(int recipesid) {
        this.recipesid = recipesid;
        return this;
    }

    public String getName() {
        return name;
    }

    public recipes setName(String name) {
        this.name = name;
        return this;
    }

    public double  getCalorie() {
        return calorie;
    }

    public recipes setCalorie(double  calorie) {
        this.calorie = calorie;
        return this;
    }


    public String getNeedfood() {
        return needfood;
    }

    public recipes setNeedfood(String needfood) {
        this.needfood = needfood;
        return this;
    }

    public String getDescription1() {
        return description1;
    }

    public recipes setDescription1(String description1) {
        this.description1 = description1;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public recipes setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }
}