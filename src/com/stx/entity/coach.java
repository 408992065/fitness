package com.stx.entity;

public class coach {
    private int  coachid;
    private int userid;
    private String wxname;
    private String name;
    private String  openid;
    private int  age;
    private double hight;
    private double weight;
    private int gender;
    private String description;
    private String curl;
    private double price;
    private   String ctime;

    
	public coach() {
		
	}

	public coach(int coachid, int userid, String wxname, String name, String openid, int age, double hight,
			double weight, int gender, String description, String curl, double price, String ctime) {
		this.coachid = coachid;
		this.userid = userid;
		this.wxname = wxname;
		this.name = name;
		this.openid = openid;
		this.age = age;
		this.hight = hight;
		this.weight = weight;
		this.gender = gender;
		this.description = description;
		this.curl = curl;
		this.price = price;
		this.ctime = ctime;
	}





	public coach(int coachid, String name, int gender) {
		this.coachid = coachid;
		this.name = name;
		this.gender = gender;
	}

	public coach(int coachid, int userid, String wxname, String name, String openid, int age, double hight,
			double weight, int gender, String description) {
		this.coachid = coachid;
		this.userid = userid;
		this.wxname = wxname;
		this.name = name;
		this.openid = openid;
		this.age = age;
		this.hight = hight;
		this.weight = weight;
		this.gender = gender;
		this.description = description;
	}

	public coach(int userid, String wxname, String name, String openid, int age, double hight, double weight,
			int gender, String description) {
		this.userid = userid;
		this.wxname = wxname;
		this.name = name;
		this.openid = openid;
		this.age = age;
		this.hight = hight;
		this.weight = weight;
		this.gender = gender;
		this.description = description;
	}


	public coach(int coachid, int userid, String wxname, String name, String openid, int age, double hight,
			double weight, int gender, String description, String ctime) {
		this.coachid = coachid;
		this.userid = userid;
		this.wxname = wxname;
		this.name = name;
		this.openid = openid;
		this.age = age;
		this.hight = hight;
		this.weight = weight;
		this.gender = gender;
		this.description = description;
		this.ctime = ctime;
	}


	
	public coach(int coachid, String name, int age, double hight, double weight, int gender, String description,Double price) {
		this.coachid = coachid;
		this.name = name;
		this.age = age;
		this.hight = hight;
		this.weight = weight;
		this.gender = gender;
		this.description = description;
		this.price= price;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurl() {
		return curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getWxname() {
		return wxname;
	}


	public void setWxname(String wxname) {
		this.wxname = wxname;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getCoachid() {
        return coachid;
    }

    public coach setCoachid(int coachid) {
        this.coachid = coachid;
        return this;
    }

    public String getName() {
        return name;
    }

    public coach setName(String name) {
        this.name = name;
        return this;
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


	public int getAge() {
        return age;
    }

    public coach setAge(int age) {
        this.age = age;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public coach setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public coach setDescription(String description) {
        this.description = description;
        return this;
    }

}
