package stocks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.thread.TestNGThread;

import com.amzn.helpers.BrowserFactory;

public class StockPage {
	WebDriver driver;
	public StockPage(WebDriver cdriver) {
		this.driver = cdriver;
	}
	
	@FindBy(how = How.CSS, using="input[placeholder='Enter a company name']") 
	WebElement searchBox;	
	
	@FindBy(how = How.CSS, using="span[class=hidden-sm.hidden-xs]") WebElement searchBtn;
	
	@FindBy(how = How.CSS, using="ul[class=dropdown-menu]") WebElement stocksMenu1;
	
	@FindBy(how = How.CSS, using=".dropdown-menu li a") public List<WebElement> stocksMenu;
	
	//@FindBy(how = How.CSS, using=".col-sm-6.callout") WebElement warningCall;
	
	//@FindBy(how = How.TAG_NAME, using="h4") List<WebElement> warningCalls;
	//@FindBy(how = How.CSS, using=".h4.easy") List<WebElement> warningCalls;
	@FindBy(how = How.CSS, using=".col-sm-6.callout.callout-warning .h4.easy") List<WebElement> warningCalls;
	@FindBy(how = How.ID, using="analysis") WebElement analysisTblElm;
	

	//$("ul[class=dropdown-menu] li a")
	
	//@FIndBy(how = How.CSS, using=)

	public void searchStockByName(String sName) {
		// TODO Auto-generated method stub
		
		int i = 1;
		//System.out.println("=========: "+sName+" :==================" );
		searchBox.click(); //Using this because loosing focus after first entry.
		searchBox.sendKeys(sName);
		//searchBox.sendKeys(Keys.SPACE);
		BrowserFactory.waitUntilElementShowsUp(driver, stocksMenu1);
		
			for(WebElement we:stocksMenu) {
				/*System.out.println();
				System.out.println("#"+sNo+":"+sName);
				System.out.println("--------------------------------------");*/
				
				//if(we.getText().equalsIgnoreCase(sName)) {
					if(we.getText().contains(sName)) {
					//System.out.println("========="+we.getText());
					we.click();
					
					searchBox.click();
					try{
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
					BrowserFactory.waitUntilElementShowsUp(driver, analysisTblElm);

					int ss = warningCalls.size();
					//System.out.println("CALL Out SIZE IS:: "+ss);
					if( ss <= 2 && ss > 0) {
						for(WebElement wee:warningCalls) {
							System.out.println("CALL Out #"+i+":"+wee.getText());
							i = i+1;
							}
					}
					else if(ss == 0){
						System.out.println("No Cons, GOOD - MUST CHECK:"+sName);
						
					}
					else {
						//System.out.println("THIS STOCK HAS MANY Cons:"+sName);
					}
					
				}
					
		}
		//searchBox.sendKeys(Keys.RETURN);
			
	}
	
	/*public void warningCall() {
		searchBox.click();
		//searchBox.sendKeys("HI");
		Iterator<WebElement> itr = warningCalls.iterator();
		int i = 0;
		while(itr.hasNext()) {
			
			System.out.println("CALL Out #"+i+ itr.next().getText());
			i = i+1;
		}
		
		//System.out.println("WC---->:"+wcText);
	}*/
	
	
		/*public List<String> getMenuList() {
			searchBox.sendKeys("ITC");
			BrowserFactory.mouseOver(driver, searchBox);
	        
			WebDriverWait wait = new WebDriverWait(driver, 40);
			List<String> lbls = new ArrayList<String>();
			for(WebElement we:stocksMenu) {
				lbls.add(we.getText());
				System.out.println(lbls.size());
				System.out.println(we.getText());
			}
			return lbls;
			
		}*/
				
}



// Below method works fine by hitting the 'Return' key after entering the text and wait.
//But I want to click menu item by finding it element.
/*public void searchStockByName(String sName) {
	// TODO Auto-generated method stub
	searchBox.sendKeys(sName);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	searchBox.sendKeys(Keys.RETURN);
	
}*/


/*for(WebElement wee:warningCalls) {
	System.out.println("CALL Out #"+i+":"+wee.getText());
	i = i+1;
}*/

