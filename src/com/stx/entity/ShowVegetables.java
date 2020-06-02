package com.stx.entity;

public class ShowVegetables {
    private int kindid;
    private int foodid;
    private String name;
    private int calorie;
    private String description;
    private String ctime;
    private String url;

    public ShowVegetables(int kindid, int foodid, String name, int calorie, String description, String ctime, String url) {
        this.kindid = kindid;
        this.foodid = foodid;
        this.name = name;
        this.calorie = calorie;
        this.description = description;
        this.ctime = ctime;
        this.url = url;
    }

    public ShowVegetables(String url,String name, int foodid, String description, int calorie) {
        this.foodid = foodid;
        this.name = name;
        this.calorie = calorie;
        this.description = description;
        this.url = url;

    }


    public int getKindid() {
        return kindid;
    }

    public ShowVegetables setKindid(int kindid) {
        this.kindid = kindid;
        return this;
    }

    public int getFoodid() {
        return foodid;
    }

    public ShowVegetables setFoodid(int foodid) {
        this.foodid = foodid;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShowVegetables setName(String name) {
        this.name = name;
        return this;
    }

    public int getCalorie() {
        return calorie;
    }

    public ShowVegetables setCalorie(int calorie) {
        this.calorie = calorie;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ShowVegetables setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public ShowVegetables setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ShowVegetables setUrl(String url) {
        this.url = url;
        return this;
    }
}
