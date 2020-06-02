package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.Showfood;

public interface IShowfoodDao {
	public ArrayList<Showfood> searchFood(String name, int current, int number);

	public Showfood showFood(int foodid);

	public ArrayList<Showfood> searchFoodByKind(int kindid, int current, int number);
}
