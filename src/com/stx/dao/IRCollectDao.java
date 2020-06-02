package com.stx.dao;

import com.stx.entity.RCollect;

public interface IRCollectDao {

	public boolean deleteCollect(int rcollectid);

	public int existRCOllect(int userid, int recipesid);

	public boolean addRCOllect(RCollect rc);
}
