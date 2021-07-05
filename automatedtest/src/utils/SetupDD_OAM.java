package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SetupDD_OAM {
	static WebDriver driver=null;
	
	 @Test(dataProvider="test2data")
		
		public static void test2(String Email,String Password, String Lastname,String Postcode,String Email2,String Phone,String Frequency,String Day,String Sortcode,String Bankacnt) throws IOException, InterruptedException {
	   /* 
		 final String AUTOMATE_USERNAME = "komalsharma_uAG19a";
	  	  final String AUTOMATE_ACCESS_KEY = "2dV2ybsNXVZbcdQU4mhz";
	  	  final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"; 
	    	
	    	DesiredCapabilities caps = new DesiredCapabilities();
	    	 caps.setCapability("os_version", "10");
	 	    caps.setCapability("resolution", "1920x1080");
	 	    caps.setCapability("browser", "Chrome");
	 	    caps.setCapability("browser_version", "89.0");
	 	    caps.setCapability("os", "Windows");
	 	    caps.setCapability("name", "SetupDD_OAM"); // test name
	 	    caps.setCapability("build", "BStack Build Number 1"); 
	 	   caps.setCapability("project", "Thames water");
	 	   caps.setCapability("browserstack.debug", "true");
	    	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    	*/
		 System.setProperty("webdriver.chrome.driver","C:/Users/KO20024896/Downloads/EclipseIDEPhoton/CucumberJava/src/test/resources/driver1/chromedriver.exe");
		   driver= new ChromeDriver();
	    		    	 
	    	driver.get("https://sitecore-eun-oam-uat2-single.azurewebsites.net/");
		    driver.manage().window().maximize();
		    WebDriverWait wait = new WebDriverWait(driver,10);
		  //Cookies 
			  /*  WebElement t = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		        // check visibility with isDisplayed()
		        if (t.isDisplayed()){
		           System.out.println("Element is visible");
		           t.click();
		        }
		        else {
		        System.out.println("Element is invisible");
		        } 
		        */
		        driver.findElement(By.id("tab-log-in")).click() ;
		        JavascriptExecutor js1 = (JavascriptExecutor) driver;
				WebElement Element4 = driver.findElement(By.xpath("//span[text()='Email address']/../following-sibling::div/input"));
				js1.executeScript("arguments[0].scrollIntoView();", Element4);
				 wait.until(ExpectedConditions.visibilityOf(Element4));
				Element4.sendKeys(Email);
				
				//next button
				driver.findElement(By.id("btnNext")).click();
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				 driver.findElement(By.id("password")).sendKeys(Password) ;
				 //sign in btn
				 
				 driver.findElement(By.xpath("//button[@id='next']")).click();
					
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 driver.findElement(By.xpath("(//a[@class=\"btn btn-tw-primary ui-text-anclink-viewact\"])[2]")).click();
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 driver.findElement(By.xpath("//a[contains(text(),'Set up Direct Debit')]")).click();
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 WebElement radiobutton=driver.findElement(By.xpath("//input[@id='moreThanOneSignature2']/../span"));
					wait.until(ExpectedConditions.visibilityOf(radiobutton));
					JavascriptExecutor jse1 = (JavascriptExecutor)driver;
					jse1.executeScript("arguments[0].click()", radiobutton);
					
					//screen2 checkbox
					WebElement check=driver.findElement(By.xpath("//input[@id='agreementChecked']/../span"));
					JavascriptExecutor jse2 = (JavascriptExecutor)driver;
					jse2.executeScript("arguments[0].click()", check);
					//next button
					driver.findElement(By.id("btnNext")).click();
					
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					
					//Frequency dropdown
					Select drp1 = new Select(driver.findElement(By.xpath("//span[text()='How often would you like to pay?']/../following-sibling::div/select")));
				    drp1.selectByVisibleText(Frequency);
				    System.out.println(Frequency);
				    String Expected1 =  "Monthly";
					String Actual1 = Frequency;
					
			        System.out.println(Actual1);

			    if(Expected1.equals(Actual1)){
			        System.out.println("Pass");
			        Select drp2 = new Select(driver.findElement(By.xpath("//span[text()='What date would you like to pay on?']/../following-sibling::div/select")));
				    drp2.selectByVisibleText(Day);
			    }
			        else {
			            System.out.println("Fail");
			        }
driver.findElement(By.xpath("//span[text()='Sort code']/../following-sibling::div/input")).sendKeys(Sortcode);
			    
				//bank account number
			    driver.findElement(By.xpath("//span[text()='Bank account number']/../following-sibling::div/input")).sendKeys(Bankacnt);
			  //next button
			    driver.findElement(By.id("btnNext")).click();
			    JavascriptExecutor js5 = (JavascriptExecutor) driver;
				 
				  // js5.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				   WebElement Element = driver.findElement(By.xpath("//div[@class=\"checkbox\"]/label/input"));
				   wait.until(ExpectedConditions.visibilityOf(Element));
				   js5.executeScript("arguments[0].click()", Element);
				 //submit
						WebElement button = driver.findElement(By.xpath("//button[@id=\"btnNext\"]"));
						JavascriptExecutor jse4 = (JavascriptExecutor)driver;
						jse4.executeScript("arguments[0].click()", button);
						wait.until(ExpectedConditions.visibilityOf(button));
						
						//Confirmation page
						String Expected =  "Set Up Direct Debit";
						String Actual = driver.findElement(By.xpath("//h1[@class=\"confirmation-heading\"]")).getText();
						
				        System.out.println(Actual);

				    if(Expected.equals(Actual)){
				        System.out.println("Pass");
				    }
				        else {
				            System.out.println("Fail");
				        }
						
				   
				    if(Expected.equals(Actual)){
				    	markTestStatus("passed","Yaay title contains 'BrowserStack'!",driver);
				    }
				    else {
				    	markTestStatus("failed","Naay title does not contain 'BrowserStack'!",driver);
				    }
				
			   driver.quit();	
	    
	  }
	  
	  
	  @DataProvider(name="test2data")
		
		public Object[][] getData() {
			String excelpath="C:\\Users\\KO20024896\\Downloads\\EclipseIDEPhoton\\CucumberJava\\excel\\data.xlsx";
			Object data [][]=testdata(excelpath,"Sheet1");
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
