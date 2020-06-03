package com.stx.entity;

public class rtalk {
	private int rtalkid;
	private  int recipesid;
    private  int userid;
    private String description;
    private String ctime;

    
    public rtalk(int recipesid, int userid, String description) {
		this.recipesid = recipesid;
		this.userid = userid;
		this.description = description;
	}
	public rtalk( int rtalkid,int recipesid, int userid, String ctime,String description) {
       this.rtalkid=rtalkid;
    	this.recipesid = recipesid;
        this.userid = userid;
        this.ctime = ctime;
        this.description = description;
    }
    public int getRtalkid() {
		return rtalkid;
	}

	public void setRtalkid(int rtalkid) {
		this.rtalkid = rtalkid;
	}
    public int getRecipesid() {
        return recipesid;
    }

    public rtalk setRecipesid(int recipesid) {
        this.recipesid = recipesid;
        return this;
    }

    public int getUserid() {
        return userid;
    }

    public rtalk setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public rtalk setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public rtalk setDescription(String description) {
        this.description = description;
        return this;
    }
}