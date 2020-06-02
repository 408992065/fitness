package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.AllCorrect;

public interface ICorrectDao {
	
	public ArrayList<AllCorrect> getAllGuidance(int userid,int status);
}
