package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.RecommendJVideo;

public interface IRecommendJVideoDao {

	 public ArrayList<RecommendJVideo> recommendJVideo(int current ,int number);

}
