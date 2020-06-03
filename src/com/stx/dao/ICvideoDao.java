package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.cvideo;

public interface ICvideoDao {

	public boolean addcvideo(cvideo cs);

	public boolean editcvideo(cvideo cs);

	public boolean deletecvideo(int cvideoid);

	public ArrayList<cvideo> getAllcvideo();

	public ArrayList<cvideo> getcvideo(int coachid);

	public cvideo getOneCVideo(int cvideoid);
}
