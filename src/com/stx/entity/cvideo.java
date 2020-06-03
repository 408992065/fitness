package com.stx.entity;

public class cvideo {
    private int cvideoid;
    private String name;
    private String url;
    private int  coachid;
    private String ctime;

    
    public cvideo() {
    	
	}

	public cvideo(int cvideoid, String name, String url,int  coachid, String ctime ) {
        this.cvideoid = cvideoid;
        this.name = name;
        this.url = url;
        this.coachid = coachid;
        this.ctime = ctime;
    }

    public cvideo(String name, String url, int coachid, String ctime) {

        this.name = name;
        this.url = url;
        this.coachid = coachid;
        this.ctime = ctime;

    }

    public int getCvideoid() {
        return cvideoid;
    }

    public cvideo setCvideoid(int cvideoid) {
        this.cvideoid = cvideoid;
        return this;
    }

    public String getName() {
        return name;
    }

    public cvideo setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public cvideo setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCtime() {
        return ctime;
    }

    public cvideo setCtime(String ctime) {
        this.ctime = ctime;
        return this;
    }

    public int getCoachid() {
        return coachid;
    }

    public cvideo setCoachid(int coachid) {
        this.coachid = coachid;
        return this;
    }
}
