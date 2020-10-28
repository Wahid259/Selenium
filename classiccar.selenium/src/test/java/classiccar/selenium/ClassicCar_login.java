package classiccar.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassicCar_login {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

	public WebDriver driver;
	public static String email = "murshida.metu@gmail.com";
	public static String pass = "Selenium1";
	public static WebElement element;
	public static String expectedUser = "Hi, murshida!";

	@Test
	public static void loginAccount() throws InterruptedException {

		// code for opening chrome browser.
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// code for navigating to the URL & maximizing browser
		driver.get("https://classiccars.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		;
		driver.manage().window().maximize();

		// code for click action using selenium
		driver.findElement(By.xpath("//a[@id='UserLoginJumperLink']")).click();

		// code for writing something in Text box using sendkey method in selenium
		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-password']")).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='login']")).submit();

		// code for extracting any text from UI using get text method
		element = driver.findElement(By.xpath("//a[@id='UserNameAccountLink']"));
		Thread.sleep(1000);
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

		/*
		 * driver.findElement(By.xpath("//a[@id='navFind']")).click();
		 * driver.findElement(By.xpath("//input[@id='YearFrom']")).sendKeys("2015");
		 * 
		 * //code for clearing existing value from test box using clear method
		 * driver.findElement(By.xpath("//input[@id='YearTo']")).clear();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//input[@id='YearTo']")).sendKeys("2020");
		 * 
		 * // code for selecting desire value from dropdown element =
		 * driver.findElement(By.xpath("//select[@id='Model']")); Select select = new
		 * Select(element); select.deselectByVisibleText("Acura");
		 * 
		 * 
		 * //driver.findElement(By.xpath("//input[@id='refine-search-button']")).click()
		 * ;
		 */

		// code for put the values for which car I wanted to search
		driver.findElement(By.xpath("//input[@id='YearFrom']")).click();
		driver.findElement(By.xpath("//input[@id='YearFrom']")).sendKeys("2015");
		driver.findElement(By.xpath("//input[@id='YearTo']")).click();
		driver.findElement(By.xpath("//input[@id='YearTo']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='YearTo']")).sendKeys("2020");

		// code for dropdown
		// driver.findElement(By.xpath("//select[@id='Make']")).click();
		Select mydrpdwn = new Select(driver.findElement(By.id("coco")));
		Thread.sleep(1000);
		mydrpdwn.selectByVisibleText("Ace");
		Thread.sleep(1000);

		/*
		 * driver.findElement(By.xpath("//select[@id='Model']")).click(); Select
		 * mydrpdwn = new Select(driver.findElement(By.id("Model")));
		 * mydrpdwn.selectByVisibleText("Ace");
		 */

		driver.findElement(By.xpath("//button[@id='main-search-button']")).click();

		// Nevigate one step backword
		// driver.navigate().back();

		// driver.close();
		// driver.quit();

	}

}
