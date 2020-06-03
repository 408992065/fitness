package com.stx.dao;

import com.stx.entity.voice;

public interface IVoiceDao {
	public boolean addvoice(voice cs);

	public boolean deleteVoice(int voiceid);
}
