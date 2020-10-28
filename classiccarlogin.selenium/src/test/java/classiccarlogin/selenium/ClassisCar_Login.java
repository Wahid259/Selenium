package classiccarlogin.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassisCar_Login {
	public WebDriver driver;
	public static String email = "rahimbatper@gmail.com";
	public static String pass = "Selenium123";
	public static WebElement element;
	public static String expectedUser = "Hi, Wahid!";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		// code for navigating to the URL & maximizing browser
		driver.get("https://classiccars.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		;
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='UserLoginJumperLink']")).click();

		// code for writing something in Text box using sendkey method in selenium
		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-email']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-password']")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='login']")).submit();

	}

}
