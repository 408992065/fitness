package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.ShowRTalk;
import com.stx.entity.ShowUserRTalk;
import com.stx.entity.rtalk;

public interface IrtalkDao {

	public boolean addrtalk(rtalk cs);

	public boolean deletertalk(int rtalkid);

	public ArrayList<rtalk> getAllralk();

	public ArrayList<ShowRTalk> getralk(int recipesid);

	public ArrayList<ShowUserRTalk> getUserRTalk(int userid);
}
