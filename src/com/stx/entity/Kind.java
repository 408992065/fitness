package com.stx.entity;

public class Kind {
	private int kindid;
	private String name;
	private String kurl;
	private String time;
	
	
	public Kind(int kindid, String name, String kurl, String time) {
		this.kindid = kindid;
		this.name = name;
		this.kurl = kurl;
		this.time = time;
	}
	public int getKindid() {
		return kindid;
	}
	public void setKindid(int kindid) {
		this.kindid = kindid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKurl() {
		return kurl;
	}
	public void setKurl(String kurl) {
		this.kurl = kurl;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
