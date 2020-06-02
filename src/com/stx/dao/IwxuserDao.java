package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.wxuser;

public interface IwxuserDao {

	public boolean addwxuser(wxuser cs);

	public boolean addWxuserBynameAndDenger(wxuser cs);

	public boolean deletewxuser(wxuser cs);

	public boolean editFirstWxuser(wxuser cs);

	public boolean editwxuser(wxuser cs);

	public ArrayList<wxuser> getAllwxuser();

	public wxuser getwxuser(int userid);

	public int existUser(String openid);
}
