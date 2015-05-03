package com.cvgenerator.service.guice;

import com.cvgenerator.dao.CvDao;
import com.cvgenerator.resource.CvResource;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletScopes;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class CvServiceModule extends  AbstractModule {

	@Override
	protected void configure() {
		bind(CvResource.class).in(ServletScopes.REQUEST);
		bind(CvService.class).in(ServletScopes.REQUEST);
		bind(CvDao.class).in(Singleton.class);
	}
	
	@Provides
    public Mongo getMongo() {
        MongoClientURI mongoURI = new MongoClientURI("mongodb://127.0.0.1:27017");
        return new MongoClient(mongoURI);
    }
}
