package com.cvgenerator.service.guice;

import static org.mockito.Mockito.mock;

import com.cvgenerator.dao.CvDao;
import com.google.inject.AbstractModule;

public class ServiceTestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CvDao.class).toInstance(mock(CvDao.class));
	}

}
