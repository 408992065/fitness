package com.stx.entity;

public class Showfood {
	private int foodid;
    private String kname;
    private String fname;
    private double  calorie;
    private String description;
    private String url;
    



    public Showfood(int foodid, String kname, String fname, double  calorie, String description, String url) {
		this.foodid = foodid;
		this.kname = kname;
		this.fname = fname;
		this.calorie = calorie;
		this.description = description;
		this.url = url;
	}

	public Showfood(int foodid, String kname, String fname, int calorie, String url) {
		this.foodid = foodid;
		this.kname = kname;
		this.fname = fname;
		this.calorie = calorie;
		this.url = url;
	}

	public Showfood() {
		
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFoodid() {
        return foodid;
    }

    public Showfood setFoodid(int foodid) {
        this.foodid = foodid;
        return this;
    }

    public double  getCalorie() {
        return calorie;
    }

    public Showfood setCalorie(double  calorie) {
        this.calorie = calorie;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Showfood setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Showfood setUrl(String url) {
        this.url = url;
        return this;
    }
}
