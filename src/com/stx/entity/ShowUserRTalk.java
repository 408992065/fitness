package com.stx.entity;

public class ShowUserRTalk {
		private int rtalkid;
		private String uname;
		private String description;
		private String ctime;
		private String rname;
		private int calorie;
		private String needfood;
		private String url;
		
		
		public ShowUserRTalk(int rtalkid, String uname, String description, String ctime, String rname, int calorie,
				String needfood, String url) {
			this.rtalkid = rtalkid;
			this.uname = uname;
			this.description = description;
			this.ctime = ctime;
			this.rname = rname;
			this.calorie = calorie;
			this.needfood = needfood;
			this.url = url;
		}
		public int getRtalkid() {
			return rtalkid;
		}
		public void setRtalkid(int rtalkid) {
			this.rtalkid = rtalkid;
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
		public String getRname() {
			return rname;
		}
		public void setRname(String rname) {
			this.rname = rname;
		}
		public int getCalorie() {
			return calorie;
		}
		public void setCalorie(int calorie) {
			this.calorie = calorie;
		}
		public String getNeedfood() {
			return needfood;
		}
		public void setNeedfood(String needfood) {
			this.needfood = needfood;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	
}
