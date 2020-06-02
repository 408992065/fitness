package com.stx.entity;

public class RecommendJVideo {
	private int cvideoid;
	private String cname;
	private String vname;
	private String url;
	private int count;
	
	public RecommendJVideo(int cvideoid, String cname, String vname, String url, int count) {
		this.cvideoid = cvideoid;
		this.cname = cname;
		this.vname = vname;
		this.url = url;
		this.count = count;
	}

	public int getCvideoid() {
		return cvideoid;
	}

	public void setCvideoid(int cvideoid) {
		this.cvideoid = cvideoid;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
