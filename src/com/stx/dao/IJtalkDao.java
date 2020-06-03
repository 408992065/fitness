package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.Jtalk;
import com.stx.entity.ShowJTalk;

public interface IJtalkDao {

	public boolean addJtalk(Jtalk cs);

	public boolean deleteJtalk(int jtalkid);

	public ArrayList<Jtalk> getAlljtalk();

	public ArrayList<ShowJTalk> getUserJtalk(int userid);

	public ArrayList<ShowJTalk> getJtalk(int cvideoid);
}
