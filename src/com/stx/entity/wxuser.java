package com.stx.entity;

public class wxuser {
    private int  userid;
    private String name;
    private double hight;
    private double weight;
    private int  age;
    private String  openid;
    private int gender;
    private String purl;
    private   String ctime;


	public wxuser(int userid, String name, double hight, double weight, int age, int gender) {
		this.userid = userid;
		this.name = name;
		this.hight = hight;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}

	public wxuser(int userid, double hight, double weight) {
		this.userid = userid;
		this.hight = hight;
		this.weight = weight;
	}

	public wxuser() {
		super();
	}

	public wxuser(int userid,double hight, double weight, int age) {
    	this.userid=userid;
		this.hight = hight;
		this.weight = weight;
		this.age = age;
	}

	public wxuser(String name, String openid, int gender, String purl) {
		this.purl= purl;
		this.name = name;
		this.openid = openid;
		this.gender = gender;
	}

	public wxuser(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public wxuser(String name, double hight, double weight, int age, int gender) {
		this.name = name;
		this.hight = hight;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}

	public wxuser(int userid, String name, double hight, double weight, int age, String openid, int gender, String ctime) {
		this.userid = userid;
		this.name = name;
		this.hight = hight;
		this.weight = weight;
		this.age = age;
		this.openid = openid;
		this.gender = gender;
		this.ctime = ctime;
	}
	

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getUserid() {
        return userid;
    }

    public wxuser setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getName() {
        return name;
    }

    public wxuser setName(String name) {
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

    public wxuser setAge(int age) {
        this.age = age;
        return this;
    }


    public String getCtime() {
        return ctime;
    }

    public wxuser setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }


    public int getGender() {
        return gender;
    }

    public wxuser setGender(int gender) {
        this.gender = gender;
        return this;
    }
}
