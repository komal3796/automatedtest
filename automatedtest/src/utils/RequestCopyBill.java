package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class RequestCopyBill {
	static WebDriver driver=null;

	 @Test(dataProvider="test6data")
		
		public static void test6(String testurl,String Account,String Firstname, String Lastname,String Postcode,String Securityques,String SecuOption,String PayMethod,String Last4digit,String day,String month,String year,String Email,String Phone,String Reason,String FB_Text,String FB_drp1,String FB_drp2) throws IOException, InterruptedException 
	 {
		 
		
		 final String AUTOMATE_USERNAME = "komal_V7afDy";
		  final String AUTOMATE_ACCESS_KEY = "eGxD9jjMqbCtQkviVE1E";
	  	  final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"; 
	    	
	    	DesiredCapabilities caps = new DesiredCapabilities();
	    	 caps.setCapability("os_version", "10");
	 	    caps.setCapability("resolution", "1920x1080");
	 	    caps.setCapability("browser", "Chrome");
	 	    caps.setCapability("browser_version", "89.0");
	 	    caps.setCapability("os", "Windows");
	 	    caps.setCapability("name", "RequestCopyBill"); // test name
	 	    caps.setCapability("build", "BStack Build Number 1"); 
	 	   caps.setCapability("browserstack.debug", "true");
	    	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		   driver.get(testurl);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    WebDriverWait wait = new WebDriverWait(driver,10);
		    WebElement t = driver.findElement(By.xpath("//div[@id='onetrust-button-group']/button[2]"));
		    wait.until(ExpectedConditions.visibilityOf(t));
            // check visibility with isDisplayed()
            if (t.isDisplayed()){
               System.out.println("Element is visible");
              t.click();
            }
            else {
            System.out.println("Element is invisible");
            }
		  
		    Actions action = new Actions(driver);
	        WebElement element1 = driver.findElement(By.xpath("//*[@class='current']/ul/li/span/a"));
	        action.moveToElement(element1).perform();
	        WebElement element2 = driver.findElement(By.xpath("//span/a[contains(text(),'Billing and payment')]"));
			wait.until(ExpectedConditions.visibilityOf(element2)); //this will wait for elememt to be visible for 20 seconds
			element2.click();
			
			
			
			 WebElement element3 = driver.findElement(By.xpath("//a[contains(text(),'Request a copy of your bill')]"));
			 wait.until(ExpectedConditions.visibilityOf(element3));
				element3.click();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement Element4 = driver.findElement(By.xpath("//div[@id='theForm']/div/div/div/div/label[@class=\"control-label\"]/span[text()='Your account number']/../following-sibling::div[@class=\"fieldset\"]/input"));
				js.executeScript("arguments[0].scrollIntoView();", Element4);
				Element4.sendKeys(Account);
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
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				//security question
				
				
				WebElement secu = driver.findElement(By.xpath("//span[text()='Security question']/../following-sibling::div/select"));
				wait.until(ExpectedConditions.visibilityOf(secu));
				secu.click();
				
				Select secuq = new Select(secu);
				secuq.selectByValue(Securityques);
				
				if(SecuOption.equals("Pay")) {
				WebElement SecuPay = driver.findElement(By.xpath("//span[text()='Your usual payment method']/../following-sibling::div/select"));
				
				Select secuans1 = new Select(SecuPay);
				secuans1.selectByValue(PayMethod);
	 }
				
				else if(SecuOption.equals("DOB")){
								
			WebElement d= driver.findElement(By.xpath("//div[@class=\"col-sm-2 col-xs-3\"]/input[@placeholder=\"DD\"]"));
			d.sendKeys(day);
			driver.findElement(By.xpath("//span[text()='Your date of birth']/../following-sibling::div/div/div[2]/input")).sendKeys(month);
			driver.findElement(By.xpath("//span[text()='Your date of birth']/../following-sibling::div/div/div[3]/input")).sendKeys(year);
					}
				
				else if(SecuOption.equals("Phone")){
				WebElement SecuPhone = driver.findElement(By.xpath("//span[text()='Last 4 digits of your phone number']/../following-sibling::div/input"));
				SecuPhone.sendKeys(Last4digit);
					}	
							
					
				next1.click();
				
				
				
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//email
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				WebElement Emailaddress = driver.findElement(By.xpath("//span[text()='Email address']/../following-sibling::div/input"));
				js1.executeScript("arguments[0].scrollIntoView();", Emailaddress);
				 wait.until(ExpectedConditions.visibilityOf(Emailaddress));
				Emailaddress.sendKeys(Email);
				
				
				
				//phone no
				driver.findElement(By.xpath("//span[text()='Preferred  Number']/../following-sibling::div/input[@type='tel']")).sendKeys(Phone);
				//reason dropdown
				Select drpreason = new Select(driver.findElement(By.xpath("//span[contains(text(),'Reason')]/../following-sibling::div/select")));
				drpreason.selectByValue(Reason);
				next1.click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//submit
				driver.findElement(By.id("btnNext")).click();
				Thread.sleep(2000);
				String actual = "Thanks, we've received your request for a copy of your most recent bill.";
				String expected = driver.findElement(By.xpath("//div[@name=\"confirmationPage\"]/section/h2")).getAttribute("textContent");
				
				 System.out.println(expected);
				   if(expected.equals(actual)){
				    	System.out.println("passed");
				    }
				    else {
				    	System.out.println("failed");
				    }
				   
				   //feedback
				   WebElement star = driver.findElement(By.xpath("//div[@class=\"star-rating\"]/label/input[@value=\"5\"]"));
					JavascriptExecutor jse5 = (JavascriptExecutor)driver;
					jse5.executeScript("arguments[0].click()", star);
					jse5.executeScript("window.scrollBy(0,1000)");
					
					JavascriptExecutor js7 = (JavascriptExecutor) driver;
					WebElement Elementtext = driver.findElement(By.id("feedback_comment"));
					js7.executeScript("arguments[0].scrollIntoView();", Elementtext);
					 wait.until(ExpectedConditions.visibilityOf(Elementtext));
					Elementtext.sendKeys(FB_Text);
					
					Select drp4 = new Select(driver.findElement(By.xpath("//select[@id=\"feedback_CurrentExperience\"]")));
					drp4.selectByVisibleText(FB_drp1);
					
					Select drp5 = new Select(driver.findElement(By.xpath("//select[@id=\"feedback_FutureExperience\"]")));
					drp5.selectByVisibleText(FB_drp2);
					
					driver.findElement(By.xpath("//button[@id=\"btnNext\"]")).click();
					String actual1 = "Thank you for your feedback";
					String expected1= driver.findElement(By.xpath("//section[@class=\"confirmation-heading\"]/h1")).getAttribute("textContent");
					if(expected1.equals(actual1)){
				    	System.out.println("feedback submitted");
				    }
				    else {
				    	System.out.println("failed");
				    }
					
					try {
				    	wait.until(ExpectedConditions.titleContains("Request a copy"));
				    	markTestStatus("passed","Yaay Request copy bill successful",driver);
				    }
				    catch(Exception e) {
				    	markTestStatus("failed","Naay Request copy bill not successful ",driver);
				    }
					 driver.quit();
	}
	 @DataProvider(name="test6data")
		
		public Object[][] getData() {
			String excelpath="C:\\Users\\KO20024896\\Downloads\\EclipseIDEPhoton\\CucumberJava\\excel\\data3.xlsx";
			Object data [][]=testdata(excelpath,"ReqCopyBill");
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
		 public static void markTestStatus(String status, String reason, WebDriver driver) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
			  }

}
