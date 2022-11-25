package com.laboratorio5.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTest {
	private WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://www.google.com/");
	}
	@Test
	public void GoogleSearchTest() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Importancia de la Ingenieria de Software.");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Importancia de la Ingenieria de Software. - Buscar con Google" , driver.getTitle());
	}
	@After
    public void tearDown() {
    	driver.quit();
    }
	
}