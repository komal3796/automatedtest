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
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class demo {
	
	
	    @Test(dataProvider="test1data")
		
		public static void test1(String Account,String Firstname, String Lastname,String Postcode,String Email,String Phone,String Frequency,String Day,String Sortcode,String Bankacnt) throws IOException, InterruptedException {
	    final String AUTOMATE_USERNAME = "komalsharma_uAG19a";
	  	  final String AUTOMATE_ACCESS_KEY = "2dV2ybsNXVZbcdQU4mhz";
	  	  final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"; 
	    	
	    	DesiredCapabilities caps = new DesiredCapabilities();
	    	 caps.setCapability("os_version", "10");
	 	    caps.setCapability("resolution", "1920x1080");
	 	    caps.setCapability("browser", "Chrome");
	 	    caps.setCapability("browser_version", "89.0");
	 	    caps.setCapability("os", "Windows");
	 	    caps.setCapability("name", "SetupDD_Chrome"); // test name
	 	    caps.setCapability("build", "BStack Build Number 1"); 
	 	   caps.setCapability("browserstack.debug", "true");
	    	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    		    	 
	    	driver.get("https://myaccount-ppn.thameswater.co.uk");
		    driver.manage().window().maximize();
		    WebDriverWait wait = new WebDriverWait(driver,10);
		  //Cookies 
			    WebElement t = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		        // check visibility with isDisplayed()
		        if (t.isDisplayed()){
		           System.out.println("Element is visible");
		           t.click();
		        }
		        else {
		        System.out.println("Element is invisible");
		        } 
		        Actions action = new Actions(driver);
		        WebElement element = driver.findElement(By.xpath("//*[@class='current']/ul/li/span/a"));
		        action.moveToElement(element).perform();
		        WebElement element1 = driver.findElement(By.xpath("//div[@class='tout-content']/span[contains(text(),'Set up a Direct Debit ')]"));
				wait.until(ExpectedConditions.visibilityOf(element1)); //this will wait for elememt to be visible for 20 seconds
				element1.click();
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
				
				//next button
				WebElement next1=driver.findElement(By.xpath("//button[@id='btnNext']"));
				next1.click();
				
				WebElement radiobutton=driver.findElement(By.xpath("//input[@id='moreThanOneSignature2']/../span"));
				wait.until(ExpectedConditions.visibilityOf(radiobutton));
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("arguments[0].click()", radiobutton);
				
				//screen2 checkbox
				WebElement check=driver.findElement(By.xpath("//input[@id='agreementChecked']/../span"));
				JavascriptExecutor jse2 = (JavascriptExecutor)driver;
				jse2.executeScript("arguments[0].click()", check);
				//next button
				next1.click();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
				//email
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				WebElement Element4 = driver.findElement(By.xpath("//span[text()='Email address']/../following-sibling::div/input"));
				js1.executeScript("arguments[0].scrollIntoView();", Element4);
				 wait.until(ExpectedConditions.visibilityOf(Element4));
				Element4.sendKeys(Email);
				
				
				
				//phone no
				driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(Phone);
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
				
			    
			   
			     //On receipt of your bill.
			    //bank details
			    //sort code
			    driver.findElement(By.xpath("//span[text()='Sort code']/../following-sibling::div/input")).sendKeys(Sortcode);
			    
				//bank account number
			    driver.findElement(By.xpath("//span[text()='Bank account number']/../following-sibling::div/input")).sendKeys(Bankacnt);
			  //next button
			   next1.click();
			   
			   
			   //checkbox
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
				String Expected =  "We've successfully received your request to set up a Direct Debit.";
				String Actual = driver.findElement(By.xpath("//h1[@class=\"confirmation-heading\"]")).getText();
				
		        System.out.println(Actual);

		    if(Expected.equals(Actual)){
		        System.out.println("Pass");
		    }
		        else {
		            System.out.println("Fail");
		        }
				
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				
				Actions a = new Actions(driver);
				//scroll down a page
				a.sendKeys(Keys.PAGE_DOWN).build().perform();
				
				//feedback
				WebElement star = driver.findElement(By.xpath("//div[@class=\"star-rating\"]/label/span"));
				JavascriptExecutor jse5 = (JavascriptExecutor)driver;
				jse5.executeScript("arguments[0].click()", star);
				
				
			   
			   

			   //Mailinator
			   driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			   ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			   driver.switchTo().window(tabs.get(0));
			   //To navigate to new link/URL in 2nd new tab
			  
			    driver.get("https://www.mailinator.com");
			   driver.findElement(By.xpath("//input")).sendKeys("data78");
			   
			   driver.findElement(By.id("go-to-public")).click();
			   
			   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			   driver.findElement(By.xpath("(//td[contains(text(),'Thames Water')])[1]")).click();
			   //C4C
			   
			  
			   driver.switchTo().window(tabs.get(0));
	 driver.get("https://my319422.crm.ondemand.com/");
			   
			   driver.findElement(By.id("USERNAME_FIELD-inner")).sendKeys("Ksharma3");
			   driver.findElement(By.id("PASSWORD_FIELD-inner")).sendKeys("Waterthames@99");
			   driver.findElement(By.id("LOGIN_LINK_CONTENT")).click();
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			   driver.findElement(By.id("__panel6-CollapsedImg")).click();
			   driver.findElement(By.id("__link24")).click();
			   Thread.sleep(4000);
			   driver.findElement(By.xpath("//button[@id=\"panevariantsr_sVW5CVBKkcGmA3RZWh8W_11-searchButton\"]")).click();
			  WebElement e1= driver.findElement(By.xpath("//input[@type=\"search\"]"));
			   WebDriverWait wait1 = new WebDriverWait(driver,0);
			   wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"search\"]")));
			   e1.sendKeys("900013703228");
			   driver.findElement(By.xpath("//div[@id=\"__composite3-listdefintion8NkyN8rAB4s7CEbScRzVP0_14-0\"]")).click();
			   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			   driver.findElement(By.xpath("//div[text()=\"Tickets\"]")).click();
			   
			   driver.quit();	
	    
	  }
	  
	  
	  @DataProvider(name="test1data")
		
		public Object[][] getData() {
			String excelpath="C:\\Users\\KO20024896\\Downloads\\EclipseIDEPhoton\\CucumberJava\\excel\\data.xlsx";
			Object data [][]=testdata(excelpath,"Sheet2");
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

