package com.stx.dao;

import com.stx.entity.jcollect;

public interface IJCollectDao {

	public boolean deleteCollect(int jcollectid);

	public int existJCollect(int userid, int cvideoid);

	public boolean addJCollect(jcollect cs);
}
