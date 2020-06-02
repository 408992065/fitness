package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.ShowFollow;

public interface IShowFollowDao {

	public ArrayList<ShowFollow> getAllFollow(int userid);
}
