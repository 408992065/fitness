package com.stx.dao;

import com.stx.entity.recipes;

public interface IrecipesDao {
	public boolean addrecipes(recipes cs);

	public boolean deleterecipes(recipes cs);

	public boolean editrecipes(recipes cs);
}
