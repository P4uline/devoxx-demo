package fr.devoxx.demo.aggreg;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class MusicApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MusicApplication() {
		singletons.add(new MusicResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
