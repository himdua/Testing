package com.automation.pageHelper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class WindowClass {
	WebDriver driver;
	public void scrollToElementViewOnScreen(WebElement element) {
		Point point = element.getLocation();
		int xaxis = point.getX();
		int yaxis = point.getY();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xaxis + "," + yaxis + ");");
	}
	public boolean isAlertPresent(){
		
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e){
		return false;
		}
	}
	
	@Test
	public void a() throws InterruptedException{
		Actions action = new Actions(driver);
		WebElement el=driver.findElement(By.xpath("//button[text()='Drag Me!']"));
		WebElement el1=driver.findElement(By.xpath("//button[text()='Drag To!']"));
		Thread.sleep(5000);
		scrollToElementViewOnScreen(el);
		//action.dragAndDrop(el, el1).build().perform();
		action.clickAndHold(el).release(el1);
		//action.dragAndDrop(el, el1).build().perform();
	}
	@BeforeSuite
	public void b(){
		//FirefoxProfile firefoxProfile = new FirefoxProfile();
	    //firefoxProfile.setPreference("reader.parse-on-load.enabled",false);
	    System.setProperty("webdriver.chrome.driver", "D:\\Jbilling\\Automation\\driver\\chromedriver.exe");	    
	    System.setProperty("webdriver.chrome.driver", "D:\\Jbilling\\Automation\\driver\\chromedriver.exe");	    
	    System.setProperty("webdriver.ie.driver", "D:\\Jbilling\\Automation\\driver\\IEDriverServer.exe");	    
		   
	    //ChromeOptions options = new ChromeOptions();
	    //options.addArguments("chrome.switches","--disable-extensions");
	    //System.setProperty("webdriver.gecko.driver", "D:\\Jbilling\\Automation\\lib\\geckodriver.exe");
		//driver=new FirefoxDriver(firefoxProfile);
		//driver=new ChromeDriver(options);
	    driver=new InternetExplorerDriver();
		System.out.println("In @BeforeSuite");
		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		
		
		try{
			if(isAlertPresent()){
				Alert alert= driver.switchTo().alert();
				alert.dismiss();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		@BeforeClass
		public void c(){
			System.out.println("In @BeforeClass");
		}
	
		@BeforeGroups
		public void d(){
			System.out.println("In @BeforeGroup");
		}
		
		@BeforeMethod
		public void e(){
			System.out.println("In @BeforeMethod");
		}
		@BeforeTest
		public void f(){
			System.out.println("In @BeforeTest");
		}
		
		@AfterSuite
		public void bs(){
			System.out.println("In @AfterSuite");
		}
			@AfterClass
			public void cs(){
				System.out.println("In @AfterClass");
			}
		
			@AfterGroups
			public void ds(){
				System.out.println("In @AfterGroup");
			}
			
			@AfterMethod
			public void es(){
				System.out.println("In @AfterMethod");
			}
			@AfterTest
			public void fs(){
				System.out.println("In @AfterTest");
			}
/*public static void main(String... arg){
	

	WebDriver driver;
	System.setProperty("webdriver.gecko.driver", "D:\\Jbilling\\Automation\\lib\\geckodriver.exe");
	driver=new FirefoxDriver();
	
	Dimension windowSize=driver.manage().window().getSize();
	driver.navigate().to("https://www.gmail.com");
	System.out.println(windowSize);

}*/
}
