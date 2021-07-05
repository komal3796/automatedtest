package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MakePayment {
	
	
	 @Test(dataProvider="test1data")
		
		public static void test1(String Account,String Firstname, String Lastname,String Postcode,String Email,String Phone,String Amount,String cardno,String cardname
,String month,String year,String code) throws IOException, InterruptedException 
	 {
	    final String AUTOMATE_USERNAME = "komalsharma_Bz8Onc";
	  	  final String AUTOMATE_ACCESS_KEY = "bKA2Qwi5wyzsFZzXhydP";
	  	  final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"; 
	    	
	    	DesiredCapabilities caps = new DesiredCapabilities();
	    	 caps.setCapability("os_version", "10");
	 	    caps.setCapability("resolution", "1920x1080");
	 	    caps.setCapability("browser", "Chrome");
	 	    caps.setCapability("browser_version", "89.0");
	 	    caps.setCapability("os", "Windows");
	 	    caps.setCapability("name", "Make payment_Nonoam"); // test name
	 	    caps.setCapability("build", "BStack Build Number 1"); 
	 	   caps.setCapability("browserstack.debug", "true");
	 	  caps.setCapability("browserstack.networkLogs", "true");
	 	 caps.setCapability("browserstack.console", "info");
	 	
	    	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    		    	 
	    	driver.get("https://myaccount-ppn.thameswater.co.uk");
		    driver.manage().window().maximize();
		    WebDriverWait wait = new WebDriverWait(driver,10);
	
		  //Cookies 
		/*
		    WebElement t = driver.findElement(By.xpath("//div[@id='onetrust-button-group-parent']//button[2]"));
		        // check visibility with isDisplayed()
		        if (t.isDisplayed()){
		           System.out.println("Element is visible");
		           driver.findElement(By.xpath("//div[@id='onetrust-button-group-parent']//button[2]")).click();
		        }
		        else {
		        System.out.println("Element is invisible");
		        }
		        */
		        
		        //Hover over My account
		        Actions action = new Actions(driver);
		        WebElement element = driver.findElement(By.xpath("//*[@class='current']/ul/li/span/a"));
		        action.moveToElement(element).perform();
		      //Click on make payment link
		        
		        WebElement element1 = driver.findElement(By.xpath("//div[@class='tout-content']/span[contains(text(),'Pay your bill online ')]"));
				wait.until(ExpectedConditions.visibilityOf(element1)); //this will wait for elememt to be visible for 20 seconds
				element1.click();
				//Fill details on identification screen
				//Account no
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement Element2 = driver.findElement(By.xpath("//div[@id='theForm']/div/div/div/div/label[@class=\"control-label\"]/span[text()='Your account number']/../following-sibling::div[@class=\"fieldset\"]/input"));
				js.executeScript("arguments[0].scrollIntoView();", Element2);
				Element2.sendKeys(Account);
				//Title
				Select title = new Select(driver.findElement(By.xpath("//div[@id='theForm']/div/div/div/div/label[@class=\"control-label\"]/span[text()='Title']/../following-sibling::div[@class=\"fieldset\"]/select")));
				title.selectByVisibleText("Mr");
				//First name
				driver.findElement(By.xpath("//div[@id='theForm']/div/div/div/div/label[@class=\"control-label\"]/span[text()='First name']/../following-sibling::div[@class=\"fieldset\"]/input")).sendKeys(Firstname);
				//last name	
				driver.findElement(By.xpath("//div[@id='theForm']/div/div/div/div/label[@class=\"control-label\"]/span[text()='Last name']/../following-sibling::div[@class=\"fieldset\"]/input")).sendKeys(Lastname);
				//postcode	
				driver.findElement(By.xpath
				("//div[@id='theForm']/div/div/div/div/label[@class=\"control-label\"]/span[text()='Your account postcode']/../following-sibling::div[@class=\"input-group\"]/input")).sendKeys(Postcode);
				//find me button
				driver.findElement(By.id("findMe")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				//next button
				WebElement next1=driver.findElement(By.xpath("//button[@id='btnNext']"));
				next1.click();
				//email
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				WebElement Element4 = driver.findElement(By.xpath("//span[text()='Email address']/../following-sibling::div/input"));
				js1.executeScript("arguments[0].scrollIntoView();", Element4);
				 wait.until(ExpectedConditions.visibilityOf(Element4));
				Element4.sendKeys(Email);
				
				//phone no
				driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(Phone);
				//payment amount
				driver.findElement(By.xpath("//span[text()='Payment amount £']/../following-sibling::div/input")).sendKeys(Amount);

				   //checkbox
				   JavascriptExecutor js5 = (JavascriptExecutor) driver;
				   WebElement Element = driver.findElement(By.xpath("//div[@class=\"checkbox\"]/label/input"));
				   wait.until(ExpectedConditions.visibilityOf(Element));
				   js5.executeScript("arguments[0].click()", Element);
				   //next btn
				   next1.click();
				   //worldpay
				   driver.findElement(By.id("cardNumber")).sendKeys(cardno);
				   driver.findElement(By.id("cardholderName")).sendKeys(cardname);
				   driver.findElement(By.id("expiryMonth")).sendKeys(month);
				   driver.findElement(By.id("expiryYear")).sendKeys(year);
				   driver.findElement(By.id("securityCode")).sendKeys(code);
			//	 driver.findElement(By.id("cancelButton")).click();
				// driver.findElement(By.id("exitPaymentYesJsOff")).click();
				   
				driver.findElement(By.id("submitButton")).click();
				Thread.sleep(2000);
				   
				   //confirmation page
				  String heading1 = "We’ve got it, thanks!";
				  String expected = "We’ve got it, thanks!";
				   
				   System.out.println(heading1);
				   if(expected.equals(heading1)){
				    	markTestStatus("passed","Yaay payment successful",driver);
				    }
				    else {
				    	markTestStatus("failed","Payment not successful",driver);
				    }
				   driver.quit();	
	 }	   
	
	 @DataProvider(name="test1data")
		
		public Object[][] getData() {
			String excelpath="C:\\Users\\KO20024896\\Downloads\\EclipseIDEPhoton\\CucumberJava\\excel\\data.xlsx";
			Object data [][]=testdata(excelpath,"Sheet4");
			return data;
		}
		public  Object[][] testdata(String excelpath, String sheetname)
		{
			excelutils excel = new excelutils(excelpath,sheetname);
			int rowcount= excel.getRowCount();
			int colcount = excel.getColCount();
			
			Object data [][] = new Object[rowcount-1] [colcount];
			
			for(int i=1;i<rowcount;i++) {
				for(int j=0;j<colcount;j++) {
					Object cellData = excel.getCellData(i, j);
					
					System.out.print(cellData+ "|");
					
					data[i-1][j]=cellData;
				}
			System.out.println();	
			}
			return data;
		}
		 @DataProvider(name="test3data")
			
			public Object[][] getData3() {
				String excelpath="C:\\Users\\KO20024896\\Downloads\\EclipseIDEPhoton\\CucumberJava\\excel\\data.xlsx";
				Object data [][]=testdata(excelpath,"Sheet5");
				return data;
			}
			public  Object[][] testdata3(String excelpath, String sheetname)
			{
				excelutils excel = new excelutils(excelpath,sheetname);
				int rowcount= excel.getRowCount();
				int colcount = excel.getColCount();
				
				Object data [][] = new Object[rowcount-1] [colcount];
				
				for(int i=1;i<rowcount;i++) {
					for(int j=0;j<colcount;j++) {
						Object cellData = excel.getCellData(i, j);
						
						System.out.print(cellData+ "|");
						
						data[i-1][j]=cellData;
					}
				System.out.println();	
				}
				return data;
			}
		
	  // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
	  public static void markTestStatus(String status, String reason, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
	  }
	  
}

	  
	  


