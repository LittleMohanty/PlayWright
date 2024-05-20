package com.qa.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.admin.factory.PlayWrightFactory;
import com.qa.admin.pages.HomePage;

public class BaseTest {
	PlayWrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homePage;
	
	@BeforeTest
	public void setUp() throws IOException {
		pf=new PlayWrightFactory();
		prop=pf.initProp();
		page=pf.initBrowser(prop);
		homePage=new HomePage(page);
	}
	
	

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
		
	}

}
