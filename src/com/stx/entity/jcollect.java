package com.stx.entity;

public class jcollect {
	private int  jcollectid;
	private int  cvideoid ;
	private int   userid ;
	private String ctime;
	 
	public jcollect(int jcollectid, int cvideoid, int userid) {
		this.jcollectid = jcollectid;
		this.cvideoid = cvideoid;
		this.userid = userid;
	}
	public jcollect(int cvideoid, int userid) {
		this.cvideoid = cvideoid;
		this.userid = userid;
	}
	public jcollect(int jcollectid, int cvideoid, int userid, String ctime) {
		this.jcollectid = jcollectid;
		this.cvideoid = cvideoid;
		this.userid = userid;
		this.ctime = ctime;
	}
	public int getJcollectid() {
		return jcollectid;
	}
	public void setJcollectid(int jcollectid) {
		this.jcollectid = jcollectid;
	}
	public int getCvideoid() {
		return cvideoid;
	}
	public void setCvideoid(int cvideoid) {
		this.cvideoid = cvideoid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
}
