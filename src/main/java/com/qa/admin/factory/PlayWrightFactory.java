package com.qa.admin.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFactory {

	Playwright playWright;
	Browser browser;
	BrowserContext context;
	Page page;
	Properties prop;

	public Page initBrowser(Properties prop) {
		String browserType=prop.getProperty("browser").trim();
		System.out.println("browser name is :" + browserType);
		playWright = Playwright.create();

		switch (browserType.toLowerCase()) {
		case "chromium":
			browser = playWright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playWright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playWright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "chrome":
			browser = playWright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("please pass the correct browser name");
			break;

		}
		
		context=browser.newContext();
		  page= context.newPage();
		  page.navigate(prop.getProperty("url"));
		  return page;

	}
	public Properties initProp() throws IOException {
		FileInputStream file=new FileInputStream("./Resources/config.properties");
		prop=new Properties();
		prop.load(file);
		return prop;
		  
	}
	
	
	

}
