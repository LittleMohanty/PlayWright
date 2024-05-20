package com.qa.admin.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;
	//String locator and selector 
	
	private String search="input[name='search']";
	private String searchIcon="div#search button";
	private String searchPageHeader="div#content h1";
	
	
	//2.page constructor
	public HomePage(Page page) {
		this.page=page;	
		
	}
	//page action and method
	
	public String getHomePageTitle() {
		String title= page.title();
		System.out.println("Page title is:"+title);
		return title;
	}
	
	public String getHomePageURL() {
		String url= page.url();
		System.out.println("page url is:"+url);
		return url;
	}
	public String  doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header=page.textContent(searchPageHeader);
		System.out.println("Search header is:"+header);
		return header;
		
		
	}
	
	

}
