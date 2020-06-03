package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.FeedBack;
import com.stx.entity.ShowFeed;

public interface IFeedBackDao {

	public boolean addFeedback(FeedBack cs);

	public boolean deleteFeedback(int feedbackid);

	public boolean editFeedback(FeedBack cs);

	public ArrayList<ShowFeed> getAllFeedback();
}
