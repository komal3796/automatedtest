package utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import utils.excelutils;

public class Browserstack {
	static WebDriver driver =null;
	
	    @Test(dataProvider="test1data")
		
		public static void test1(String Account,String Password, String Lastname,String Postcode,String Email,String Phone,String Amount,String cardno,String cardname
				,String month,String year,String code) throws IOException, InterruptedException {
	    
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\KO20024896\\Downloads\\EclipseIDEPhoton\\CucumberJava\\src\\test\\resources\\updated driver\\chromedriver.exe");
		    driver= new ChromeDriver();    	 
	    	driver.get("https://sitecore-eun-oam-uat2-single.azurewebsites.net");
		    driver.manage().window().maximize();
		    WebDriverWait wait = new WebDriverWait(driver,10);
	
		     driver.findElement(By.id("tab-log-in")).click() ;
		     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		        JavascriptExecutor js1 = (JavascriptExecutor) driver;
				WebElement Element4 = driver.findElement(By.xpath("//span[text()='Email address']/../following-sibling::div/input"));				 
				Element4.sendKeys(Account);
				driver.findElement(By.id("btnNext")).click();
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				 driver.findElement(By.id("password")).sendKeys(Password) ;
//sign in btn
				 
				 WebElement next1= driver.findElement(By.xpath("//button[@id='next']"));
				next1.click();
					
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 driver.findElement(By.xpath("(//a[@class=\"btn btn-tw-primary ui-text-anclink-viewact\"])[1]")).click();
				Thread.sleep(1000);
				 JavascriptExecutor js6 = (JavascriptExecutor) driver;
				WebElement paybtn= driver.findElement(By.xpath("//a[contains(text(),'Pay')]"));
				js6.executeScript("arguments[0].click()", paybtn);
				
				
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				 JavascriptExecutor j = (JavascriptExecutor) driver;
				 	 j.executeScript("window.scrollBy(0,-500)");
				 
				 driver.findElement(By.xpath("//a[contains(text(),'specific')]")).click();
				 Thread.sleep(1000);
				 WebElement textbox = driver.findElement(By.xpath("//a[contains(text(),'specific')]/../../div[3]/div/div/input"));  
				 for (int i = 0; i < 3; i++){
					  
					textbox.sendKeys(Keys.BACK_SPACE);
				 }
				 Thread.sleep(1000);
				 
				 j.executeScript("window.scrollBy(0,500)");
				 Thread.sleep(1000);
					
					
				 
				//checkbox
				   JavascriptExecutor js5 = (JavascriptExecutor) driver;
				   WebElement check = driver.findElement(By.xpath("//div[@class=\"checkbox\"]/label/input"));
				   wait.until(ExpectedConditions.visibilityOf(check));
				   js5.executeScript("arguments[0].click()", check);
				 //next btn
				   try{
				         next1.click();
				      }
				      catch(StaleElementReferenceException e){
				    	  next1 = driver.findElement(By.xpath("//button[@id='btnNext']"));
							next1.click();
								
				        
				      }
				   
				   
				  
				   
				   //worldpay
				   driver.findElement(By.id("cardNumber")).sendKeys(cardno);
				   driver.findElement(By.id("cardholderName")).sendKeys(cardname);
				   driver.findElement(By.id("expiryMonth")).sendKeys(month);
				   driver.findElement(By.id("expiryYear")).sendKeys(year);
				   driver.findElement(By.id("securityCode")).sendKeys(code);
				 //  driver.findElement(By.id("submitButton")).click();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
					
	    
	  }
	  
	  
	  @DataProvider(name="test1data")
		
		public Object[][] getData() {
			String excelpath="C:\\Users\\KO20024896\\Downloads\\EclipseIDEPhoton\\CucumberJava\\excel\\data.xlsx";
			Object data [][]=testdata(excelpath,"Sheet5");
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
		
	  // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
	  public static void markTestStatus(String status, String reason, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
	  }

}
