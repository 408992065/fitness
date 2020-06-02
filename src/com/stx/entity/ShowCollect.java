package com.stx.entity;

public class ShowCollect {
	
	private int  jcollectid;
	private String cname;
	private String vname ;
	private String url;
	private String ctime;
	
	
	
	public ShowCollect(int jcollectid, String cname, String vname, String url, String ctime) {
		this.jcollectid = jcollectid;
		this.cname = cname;
		this.vname = vname;
		this.url = url;
		this.ctime = ctime;
	}
	public int getJcollectid() {
		return jcollectid;
	}
	public void setJcollectid(int jcollectid) {
		this.jcollectid = jcollectid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
}
