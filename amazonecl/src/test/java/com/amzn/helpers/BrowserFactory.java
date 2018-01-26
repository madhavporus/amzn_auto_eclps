package com.amzn.helpers;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserFactory {

static WebDriver driver;

public static WebDriver OpenAppInBrowser(String browserName, String urlName) {

	if(browserName.equalsIgnoreCase("Chrome")) {
		driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("Firefox")) {
		driver = new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("IE")) {
		driver = new InternetExplorerDriver();
	}
	driver.get(urlName);
	return driver;

}

public static void mouseOver(WebDriver driver, WebElement targetElm) {
	//To perform "mouse over on login menu" and locate the menu item.
		Actions action = new Actions(driver);
		action.moveToElement(targetElm).build().perform();
}

//public static void selectMenuItem(List<WebElement> linkss, String itenToSelect) {
//
//	
//}

public static void selectMenuItem(List<WebElement> linkss, String itenToSelect) {
	// TODO Auto-generated method stub
	System.out.println("***********************************");
	
	List<WebElement> ls = (List<WebElement>) linkss;
		for(WebElement we:ls) {
		//System.out.println(we.getText());
		if(we.getText().equalsIgnoreCase(itenToSelect)) {
			we.click();
		}	
	}
}

	
	
	
}


//System.out.println("***********************************");
//for(WebElement we:linkss) {
//	//System.out.println(we.getText());
//	if(we.getText().equalsIgnoreCase("Your Watchlist")) {
//		we.click();
//	}	
//}



