package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.ShowMenu;

public interface IMenuDao {

	public ArrayList<ShowMenu> getAllMenu(int userid);

	public ShowMenu getRecipes(int recipesid);

	public ArrayList<ShowMenu> getMenu(String name, int current, int number);
}
