package test.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAmazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// WebDriver driver = new SafariDriver();
		WebDriver driver = new ChromeDriver();
		// code for opening chrome browser.
		// System.setProperty("webdriver.chrome.driver","/usr/bin/safaridriver");
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		// code for navigating to the URL & maximizing browser
		driver.get("https://www.amazon.com/exec/obidos/subst/home/home.html");

		// TODO Auto-generated method stub

		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//div[@id='nav-signin-tooltip']//span[@class='nav-action-inner'][contains(text(),'Sign in')]"))
				.click();

//		driver.findElement(By.xpath(
//				"//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]"))
//				.click();
//		driver.findElement(By.xpath(
//				"//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]"))
//				.sendKeys("email");

	}

}
