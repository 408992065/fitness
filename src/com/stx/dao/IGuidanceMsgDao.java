package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.GuidanceMsg;

public interface IGuidanceMsgDao {
	public ArrayList<GuidanceMsg> getGuidanceMsg(int userid ,int status);
}
