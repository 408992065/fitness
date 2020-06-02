package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.RecommendRecipes;

public interface IRecommendRecipesDao {
	public ArrayList<RecommendRecipes> recommendMoreRecipes(String name, int current, int number);

	public ArrayList<RecommendRecipes> recommendRecipes(String name);
}
