package com.stx.entity;

public class video {
   private int videoid;
   private int coachid;
   private int userid;
   private String url;
   private int status;
   private String description; 
   private String ctime;



   
    public video() {
	
}

	public video(int coachid, int userid, String url) {
	this.coachid = coachid;
	this.userid = userid;
	this.url = url;
}

	public video(int coachid, int userid, String url,String description) {
		this.coachid = coachid;
		this.userid = userid;
		this.url = url;
		this.description = description;
	}

	public video(int videoid, int coachid, int userid, String url, String ctime) {
	this.videoid = videoid;
	this.coachid = coachid;
	this.userid = userid;
	this.url = url;
	this.ctime = ctime;
}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCoachid() {
	return coachid;
}

public void setCoachid(int coachid) {
	this.coachid = coachid;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

	public int getVideoid() {
        return videoid;
    }

    public video setVideoid(int videoid) {
        this.videoid = videoid;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public video setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public video setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }
}
