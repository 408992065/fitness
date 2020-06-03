package com.stx.entity;

public class ShowRTalk {
		private int rtalkid;
		private String uname;
		 private String description;
		 private String ctime;
		 
		 
		public ShowRTalk(int rtalkid, String uname, String description, String ctime) {
			this.rtalkid = rtalkid;
			this.uname = uname;
			this.description = description;
			this.ctime = ctime;
		}
		public String getCtime() {
			return ctime;
		}
		public void setCtime(String ctime) {
			this.ctime = ctime;
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
		 
}
