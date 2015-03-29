package com.cvgenerator.service.guice;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cvgenerator.dao.CvDao;
import com.cvgenerator.entity.Company;
import com.cvgenerator.entity.Cv;
import com.cvgenerator.entity.Experience;


public class CvServiceGuiceTest {
	
	private CvService underTest;
	
	private CvDao cvDao = mock(CvDao.class);
	
	@BeforeMethod
	public void init() {
		
		// Cas d'une injection par constructeur.
		underTest = new CvService(cvDao);
	}
	
	@Test
	public void should_find_actual_companies() {
		// Given
		@SuppressWarnings("serial")
		List<Experience> experiences = new ArrayList<Experience>() {{
			add(new Experience() {{ setCompany(new Company() {{ setName("Google"); }}); }});
			add(new Experience() {{ setCompany(new Company() {{ setName("Criteo"); }}); }});
			add(new Experience() {{ setCompany(new Company() {{ setName("Valtech"); }}); }});
		}};
		Cv cv = new Cv();
		cv.setExperiences(experiences);
		
		// When
		when(cvDao.findOne(Mockito.eq("Chuck"), Mockito.eq("Norris"))).thenReturn(cv);
		
		// Run
		List<String> result = underTest.findCompanies("Chuck", "Norris");
		
		// Then
		assertThat(result).contains("Google", "Criteo", "Valtech");
	}
}
