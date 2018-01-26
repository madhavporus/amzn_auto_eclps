package com.amzn.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.amzn.helpers.*;

public class LoginPage{
	WebDriver driver;
	
	public LoginPage(WebDriver cdriver) {
		this.driver = cdriver;
	}

//String menuItenName = "Your Watchlist";
@FindBy(how = How.ID, using="nav-link-accountList")
WebElement loginMainbtn;

@FindBy(how = How.XPATH, using ="//*[@id=\"ap_email\"]")
WebElement userIdInputElm;

@FindBy(how = How.ID, using="ap_password")
WebElement pwdInputElm;

@FindBy(how = How.ID, using="signInSubmit")
WebElement loginSubmitBtn;

//ROUGH
@FindBy(how = How.TAG_NAME, using="span") List<WebElement> linkss;

//
@FindBy(how = How.XPATH, using="//*[@id=\"nav-al-your-account\"]/a[20]/span")
WebElement yourWatchListElm;


public void LoginX(String uName, String pwd) {
	loginMainbtn.click();
	userIdInputElm.sendKeys(uName);
	pwdInputElm.sendKeys(pwd);
	loginSubmitBtn.click();
}

public void mouseOverMenu() {
	System.out.println("__________________");
	BrowserFactory.mouseOver(driver, loginMainbtn);
}

public void clickOnYourWatchList() {
	yourWatchListElm.click();		
	}


public void selectMenuItemByName(String menuItem) {
	// TODO Auto-generated method stub
	BrowserFactory.selectMenuItem(linkss, menuItem);
}

} // End of class file !!


