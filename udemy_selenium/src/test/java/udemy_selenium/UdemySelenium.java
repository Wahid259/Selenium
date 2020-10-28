package udemy_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemySelenium {
	static String browser;
	static WebDriver driver;
	public static String email = "wahid259raj@gmail.com";
	public static String pass = "Password";
	public static WebElement element;
	public static String expectedUser = "Hi, Wahid!";

	public static void main(String[] args) throws InterruptedException {

		setBrowser();
		setBrowserConfig();
		runTest();
		loginTest();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public static void setBrowser() {

		browser = "Chrome";
	}

	public static void setBrowserConfig() {

		if (browser.contains("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		if (browser.contains("Safari")) {

			System.setProperty("webdriver.chrome.driver", "/usr/bin/safaridriver");
			driver = new ChromeDriver();
		}
	}

	public static void runTest() {

//browser = "Chrome";
		driver.get(
				"https://www.udemy.com/join/login-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F%3Futm_source%3Dadwords-brand%26utm_medium%3Dudemyads%26utm_campaign%3DBrand-Udemy_la.EN_cc.ROW%26utm_term%3D_._ag_80315195513_._ad_450687451854_._de_c_._dm__._pl__._ti_kwd-310556426868_._li_9069467_._pd__._%26utm_term%3D_._pd__._kw_udemy_._%26matchtype%3De%26gclid%3DEAIaIQobChMI0NeN_tu96wIVyQorCh36Pg1GEAAYASAAEgKWj_D_BwE");
	}

	public static void loginTest() throws InterruptedException {

		// code for click action using selenium
		// driver.findElement(By.xpath("//div[@class='header--gap-auth-button--7KoL0']//span[text()='Log
		// in']")).click();

		driver.findElement(By.xpath("//input[@name='email']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

		driver.findElement(By.xpath("//input[@type='password']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);

//		Thread.sleep(1000);
		// driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

}
