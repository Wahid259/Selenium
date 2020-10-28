package bikroy.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BikroyLoginSearch {
	public WebDriver driver;
	public static String email = "rahimbatper@gmail.com";
	public static String pass = "Selenium123";
	public static WebElement element;
	public static String expectedUser = "My account";
	public static String message = "Hi, I am eagerly interested to buy your phone ! Is the price negotiable ?";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// code for opening chrome browser.
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		// code for navigating to the URL & maximizing browser
		driver.get("https://bikroy.com/en");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		// code for click action using selenium
		driver.findElement(By.xpath("//span[text()='Log in']")).click();

		// code for writing something in Text box using sendkey method in selenium
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='input_email']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='input_password']")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("//button[@class='btn--1gFez secondary--Os-e9 background--2lR9B small--1MQ15 gtm-email-login']"))
				.submit();

		// code for extracting any text from UI using get text method
		element = driver.findElement(By.xpath("//span[contains(text(),'My account')]"));
		Thread.sleep(3000);
		String actualUIUser = element.getText();
		System.out.println("Actual user in UI = " + actualUIUser);

		// code for validation using if else condition
		if (actualUIUser.equals(expectedUser)) {
			AssertJUnit.assertTrue(true);
			System.out.println(
					"Application user = " + actualUIUser + "matches with the given expected user = " + expectedUser);
		} else {
			System.out.println("Application user = " + actualUIUser + "do not match with the given expected user = "
					+ expectedUser);
			AssertJUnit.fail();
		}

		// click on mobile for search mobile device
		driver.findElement(By.xpath("//div[@class='col-6 lg-3']//span[@class='ui-sprite categories-36 mobiles']"))
				.click();

		// driver.findElement(By.xpath("//a[@id='navFind']")).click();
		driver.findElement(By.xpath("//input[@id='input_1']")).sendKeys("Xiaomi");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//button[@class='btn--1gFez secondary--Os-e9 background--2lR9B small--1MQ15 search-button--1RZdg background--2lR9B gtm-pwa-search']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='list--3NxGO']//li[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='expander--PzBP6']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='call-text--30D-J']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='display--s3dc8 card--_2NNk']//div[@class='chat-text--NpECZ'][contains(text(),'Chat')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='input_1']")).sendKeys(message);
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@class='send-button--O40Hd
		// gtm-chat-send']")).click();

		// driver.close();
		// driver.quit();

	}

}
