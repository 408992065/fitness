package com.stx.dao;

import com.stx.entity.video;

public interface IVideoDao {

	public boolean addvideo(video cs);

	public boolean deletteVideo(int videoid);

	public boolean updateStatus(int videoid);
}
