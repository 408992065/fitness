package com.stx.entity;

public class voice {
   private int voiceid;
   private String url;
    private int videoid;
    private int coachid;
   private String ctime;
   private String vlength ;
   private int userid;
   
   


public voice(int voiceid, String url, int videoid, int coachid, String ctime, String vlength, int userid) {
	this.voiceid = voiceid;
	this.url = url;
	this.videoid = videoid;
	this.coachid = coachid;
	this.ctime = ctime;
	this.vlength = vlength;
	this.userid = userid;
}
public voice(int voiceid, String url, int videoid, String ctime, int userid) {
	this.voiceid = voiceid;
	this.url = url;
	this.videoid = videoid;
	this.ctime = ctime;
	this.userid = userid;
}
public voice(int voiceid, String url, int videoid, int coachid, String ctime, int userid) {
	this.voiceid = voiceid;
	this.url = url;
	this.videoid = videoid;
	this.coachid = coachid;
	this.ctime = ctime;
	this.userid = userid;
}
public voice(String url, int videoid, String ctime) {
	this.url = url;
	this.videoid = videoid;
	this.ctime = ctime;
}
public voice(String url, int videoid, int coachid) {
	this.url = url;
	this.videoid = videoid;
	this.coachid = coachid;
}
public voice(int voiceid, String url, int videoid, int coachid, String ctime) {
	this.voiceid = voiceid;
	this.url = url;
	this.videoid = videoid;
	this.coachid = coachid;
	this.ctime = ctime;
}
public voice() {

}

public String getVlength() {
	return vlength;
}
public void setVlength(String vlength) {
	this.vlength = vlength;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getVoiceid() {
	return voiceid;
}
public void setVoiceid(int voiceid) {
	this.voiceid = voiceid;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getVideoid() {
	return videoid;
}
public void setVideoid(int videoid) {
	this.videoid = videoid;
}
public int getCoachid() {
	return coachid;
}
public void setCoachid(int coachid) {
	this.coachid = coachid;
}
public String getCtime() {
	return ctime;
}
public void setCtime(String ctime) {
	this.ctime = ctime;
}

   
}
