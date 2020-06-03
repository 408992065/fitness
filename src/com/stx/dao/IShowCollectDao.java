package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.ShowCollect;

public interface IShowCollectDao {

	public ArrayList<ShowCollect> getAllCollect(int userid);
}
