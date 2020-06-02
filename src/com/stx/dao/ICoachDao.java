package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.ShowCoach;
import com.stx.entity.coach;

public interface ICoachDao {

	public boolean addCoach(coach cs);

	public boolean deleteCoach(coach cs);

	public boolean updateCoach(coach cs);

	public ArrayList<coach> getAllCoach();

	public ShowCoach getCoach(int coachid);

	public ArrayList<ShowCoach> searchCoach(coach ch);

	public int existCoach(int userid);
}
