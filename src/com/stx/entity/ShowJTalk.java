package com.stx.entity;

public class ShowJTalk {
	private int jtalkid;
	private String uname;
	 private String description;
	 private String ctime;
	 private String url;
	 private String vname;
	 private String cname;
	 private int cvideoid;
	 
	 
		public ShowJTalk(int jtalkid, String uname, String description, String ctime,int cvideoid) {
			this.cvideoid=cvideoid;
			this.jtalkid = jtalkid;
			this.uname = uname;
			this.description = description;
			this.ctime = ctime;
		}
		public ShowJTalk(int jtalkid, String uname, String description, String ctime, String url, String vname,
				String cname) {
			this.jtalkid = jtalkid;
			this.uname = uname;
			this.description = description;
			this.ctime = ctime;
			this.url = url;
			this.vname = vname;
			this.cname = cname;
		}
	public int getJtalkid() {
		return jtalkid;
	}
	public void setJtalkid(int jtalkid) {
		this.jtalkid = jtalkid;
	}
	public int getCvideoid() {
		return cvideoid;
	}
	public void setCvideoid(int cvideoid) {
		this.cvideoid = cvideoid;
	}
	public int getRtalkid() {
		return jtalkid;
	}
	public void setRtalkid(int jtalkid) {
		this.jtalkid = jtalkid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	 
}
