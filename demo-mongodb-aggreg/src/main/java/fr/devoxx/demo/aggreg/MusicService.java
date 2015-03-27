package fr.devoxx.demo.aggreg;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MusicService {

	Logger log = LoggerFactory.getLogger(MusicService.class);
	
	public List<Disk> findDisks() {
		log.debug("Service findDisks");
		return null;
	}
}
