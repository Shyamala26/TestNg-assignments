package com.testng.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC3 {

	private WebDriver driver;

	@BeforeMethod
	public void youTubeBrowserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Shyamala\\SeeleniumTestingClass\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		Options op = driver.manage();
		Window w = op.window();
		w.maximize();
	}

	@AfterMethod
	public void closeWebDriver() {
		driver.quit();
	}

	@Test
	public void signIn() throws InterruptedException {
		WebElement signIn = driver.findElement(By.xpath("//paper-button[@id='button' and @aria-label='Sign in']"));
		signIn.click();

		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("selenium.shyamala@gmail.com");

		WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
		next.click();

		Thread.sleep(10000);

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("testing@123");

		WebElement next2 = driver.findElement(By.xpath("//span[text()='Next']"));
		next2.click();

		Thread.sleep(10000);
		WebElement subscriptions = driver.findElement(By.xpath("//yt-formatted-string[text()='History']"));
		subscriptions.click();
		Thread.sleep(10000);

		WebElement avatar = driver.findElement(By.xpath("//img[@id='img' and @alt='Avatar image']"));
		avatar.click();

		Thread.sleep(2000);

		WebElement signOut = driver.findElement(By.xpath("//yt-formatted-string[@id='label' and text()='Sign out']"));
		signOut.click();
		Thread.sleep(2000);
	}

}
