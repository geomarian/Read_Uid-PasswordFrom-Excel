package com.dp.dataProviderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilOne.testUtil;

public class MainP {

	 public static WebDriver driver; 
	
	@BeforeMethod
	
	public void setUp() throws InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "E:\\GEO\\Selenium Sample\\dataProviderTest\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "E:/GEO/Selenium Sample/dataProviderTest/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		driver.get(url);
		Thread.sleep(3000);
		System.out.println("Website is open");
	}
	
//	@Test
//	public void write(){
//		System.out.println("Hello");
//	}
	
	@DataProvider
	public Object[][] getLoginData(){
		System.out.println("Started reading file");
		Object data[][] = testUtil.getTestData("login");
	//	System.out.println("Hello2");
		return data;
	} 
	
	@Test(dataProvider = "getLoginData")
	public void dataTest(String username, String password){
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	 driver.findElement(By.id("btnLogin")).click();
//		WebElement loginbtn = driver.findElement(By.id("btnlogin"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();",loginbtn);
		
	}
	
	@Test(priority=2)
	public void dashboard() throws InterruptedException{
				WebElement clickEdit = driver.findElement(By.xpath("//b[contains(text(),'My Info')]"));
		clickEdit.click();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
