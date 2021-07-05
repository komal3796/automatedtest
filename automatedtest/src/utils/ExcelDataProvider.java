package utils;

import java.net.MalformedURLException;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver","C:/Users/KO20024896/Downloads/EclipseIDEPhoton/CucumberJava/src/test/resources/driver1/chromedriver.exe");
		   driver= new ChromeDriver();
		  
	}
	
	@Test(dataProvider="test1data")
	
	public void test1(String Account,String Firstname, String Lastname,String Postcode,String Email,String Phone,String Frequency,String Day,String Sortcode,String Bankacnt) {
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
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		//email
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Element4 = driver.findElement(By.xpath("//span[text()='Email address']/../following-sibling::div/input"));
		js1.executeScript("arguments[0].scrollIntoView();", Element4);
		 wait.until(ExpectedConditions.visibilityOf(Element4));
	    Element4.click();
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
		/*WebElement button = driver.findElement(By.xpath("//button[@id=\"btnNext\"]"));
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
		
		*/
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

}
