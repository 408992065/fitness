package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.RecommendCoach;

public interface IRecommendCoachDao {
	 public ArrayList<RecommendCoach> recommendCoach(int current ,int number);

}
