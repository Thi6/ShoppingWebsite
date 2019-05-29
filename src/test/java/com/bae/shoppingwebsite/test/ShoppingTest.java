package com.bae.shoppingwebsite.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTest {
	public static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	
	//Write a test that will search the website for an item of clothing (e.g ‘Dress’) and assert that a particular item was found. 
	@Test
	public void findItemTest() {
		driver.get("http://automationpractice.com/index.php");
/*		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		checkElement.sendKeys("Dress");
		checkElement.submit();
		checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a"));
		assertTrue(checkElement.isDisplayed());
		*/
		
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		WebDriverWait wait1 = (new WebDriverWait(driver, 20));
		checkElement.click();
		checkElement = driver.findElement(By.id("email"));
		checkElement.sendKeys("shopaholic@gmail.com");
		checkElement = driver.findElement(By.id("passwd"));
		checkElement.sendKeys("password");
		checkElement = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		checkElement.click();
		
		checkElement = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		checkElement.sendKeys("Dress");
		checkElement.submit();
		
		//puts into focus the block we need to add to cart
		checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]"));	
		checkElement.click();
		//click add to cart button
		checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span"));
		checkElement.click();
		
		//Proceed to checkout
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]")));
		checkElement = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		checkElement.click();
		
		checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
		checkElement.click();
		
		checkElement = driver.findElement(By.name("processAddress"));
		checkElement.click();
		
		checkElement = driver.findElement(By.id("cgv"));
		checkElement.click();
		
		checkElement = driver.findElement(By.name("processCarrier"));
		checkElement.click();
		
		checkElement = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		checkElement.click();
		
		checkElement = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button"));
		checkElement.click();
		
		checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div"));
		assertTrue(checkElement.isDisplayed());
		
	}
	
}
