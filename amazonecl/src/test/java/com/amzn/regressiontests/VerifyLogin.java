package com.amzn.regressiontests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amzn.helpers.BrowserFactory;
import com.amzn.pages.LoginPage;

public class VerifyLogin{
	public WebDriver driver;
	
	@BeforeTest
	public void accessTestApp() {
		driver = BrowserFactory.OpenAppInBrowser("Chrome", "https://www.amazon.com/");
	}
	
		
	@Test
	public void verifyLog() {	
	LoginPage lpage = PageFactory.initElements(driver,LoginPage.class);
	lpage.LoginX("ninjaqa1@gmail.com", "doublehelix123");
	lpage.mouseOverMenu();
	//lpage.clickOnYourWatchList();
	//lpage.selectMenuItemByName("Your Watchlist");
	lpage.selectMenuItemByName("Your Prime Video");
	}
	
	@AfterTest
	public void endAllTests() {
		driver.close();
		System.out.println("+++Test Compete! Please check the test result!+++");
	}
	
}

//("ninjaqa1@gmail.com", "doublehelix123")