package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakePaymentOAM {
	static WebDriver driver=null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/KO20024896/Downloads/EclipseIDEPhoton/CucumberJava/src/test/resources/driver1/chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.get("https://sitecore-eun-oam-uat2-single.azurewebsites.net");
		    driver.manage().window().maximize();
		   Thread.sleep(2000);
		  //Cookies 
			   /* WebElement t = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
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
				Element4.sendKeys("date79@mailinator.com");
				driver.findElement(By.id("btnNext")).click();
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				 driver.findElement(By.id("password")).sendKeys("Thames@123") ;
//sign in btn
				 
				 driver.findElement(By.xpath("//button[@id='next']")).click();
					
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 driver.findElement(By.xpath("(//a[@class=\"btn btn-tw-primary ui-text-anclink-viewact\"])[2]")).click();
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				 driver.findElement(By.xpath("//a[contains(text(),'Pay')]")).click();
				
	}		 

}
