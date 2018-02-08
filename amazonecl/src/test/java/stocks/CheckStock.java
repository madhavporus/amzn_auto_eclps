package stocks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amzn.helpers.BrowserFactory;


public class CheckStock {
	WebDriver driver;
	String[] stocknames = null;
	
	@BeforeTest
	public void accessStocksPage() {
		driver = BrowserFactory.OpenAppInBrowser("Chrome", "https://www.screener.in/");
		
	}
	
	@Test
	public void searchStock() {
		int i = 1;
		StockPage spage = PageFactory.initElements(driver,StockPage.class );
		stocknames = BrowserFactory.testDataJson();
		for(String al:stocknames) {
			System.out.println();
			System.out.println("#"+i+":"+al);
			System.out.println("--------------------------------------");
			spage.searchStockByName(al);
			//spage.warningCall();
			i = i+1;
		}
		
	}
	
	@AfterTest
	public void cleanUP() {
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		driver.close();
	}
}
