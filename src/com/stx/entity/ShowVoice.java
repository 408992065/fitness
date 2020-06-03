package com.stx.entity;

public class ShowVoice {
	 	private int voiceid;
	    private String  url;
	    private int coachid;
	    private int userid;
	    private String  ctime;
	    private String jname;
	    private String uname;
	    private String vlength ;
	 
		

		public ShowVoice(int voiceid, String url, int coachid, int userid, String ctime, String jname, String uname,
				String vlength) {
			this.voiceid = voiceid;
			this.url = url;
			this.coachid = coachid;
			this.userid = userid;
			this.ctime = ctime;
			this.jname = jname;
			this.uname = uname;
			this.vlength = vlength;
		}

		public ShowVoice(int voiceid, String jname, String url, String ctime, int coachid) {
			this.voiceid = voiceid;
			this.jname = jname;
			this.url = url;
			this.ctime = ctime;
			this.coachid = coachid;
		}

		public ShowVoice(String jname, String url, String ctime, int coachid) {
			this.jname = jname;
			this.url = url;
			this.ctime = ctime;
			this.coachid = coachid;
		}
		
		public ShowVoice(int voiceid, String jname, String url, String ctime) {
			this.voiceid = voiceid;
			this.jname = jname;
			this.url = url;
			this.ctime = ctime;
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

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public int getVoiceid() {
			return voiceid;
		}

		public void setVoiceid(int voiceid) {
			this.voiceid = voiceid;
		}

		public String getJname() {
			return jname;
		}
		public void setJname(String jname) {
			this.jname = jname;
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
		public int getCoachid() {
			return coachid;
		}
		public void setCoachid(int coachid) {
			this.coachid = coachid;
		}
	    
	    
}	
