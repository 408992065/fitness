package com.stx.dao;

import com.stx.entity.Follow;

public interface IFollowDao {

	public boolean addFollow(Follow cs);

	public boolean deleteFollow(int followid);

	public int existFollow(int userid, int coachid);
}
