package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.constant.AppConstant;

public class HomePageTest extends BaseTest {
	
	
	@Test(priority=0)
	public void homePageTitleTest() {
		String actulTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actulTitle, AppConstant.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority=1)
	public void homePageUrlTest() {
		String actulUrl=homePage.getHomePageURL();
		Assert.assertEquals(actulUrl, prop.getProperty("url"));
		
	}
	@Test(priority=2)
	public void SearchTest() {
		String ActualSearchHeader=homePage.doSearch("macbook");
		Assert.assertEquals(ActualSearchHeader, "Search - macbook");
	}
	
	
	
	
}
