package com.stx.dao;

import java.util.ArrayList;

import com.stx.entity.ShowVideo;

public interface IShowVideoDao {

	public ArrayList<ShowVideo> searchVideoOfStu(int coachid);

	public ShowVideo searchVideo(int videoid);
}
