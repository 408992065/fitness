package com.stx.entity;

public class Jtalk {
    private int jtalkid;
    private int cvideoid;
    private int  userid;
    private String description;
    private String ctime;


    public Jtalk(int cvideoid, int userid, String description) {
		this.cvideoid = cvideoid;
		this.userid = userid;
		this.description = description;
	}

	public Jtalk(int jtalkid,int cvideoid, int userid, String ctime, String description) {
        this.jtalkid = jtalkid;
        this.cvideoid = cvideoid;
        this.userid = userid;
        this.ctime = ctime;
        this.description = description;
    }

    public int getCvideoid() {
        return cvideoid;
    }

    public Jtalk setCvideoid(int cvideoid) {
        this.cvideoid = cvideoid;
        return this;
    }

    public int getUserid() {
        return userid;
    }

    public Jtalk setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public Jtalk setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Jtalk setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getJtalkid() {
        return jtalkid;
    }

    public Jtalk setJtalkid(int jtalkid) {
        this.jtalkid = jtalkid;
        return this;
    }
}