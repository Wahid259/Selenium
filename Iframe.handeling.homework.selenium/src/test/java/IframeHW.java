import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHW {
	WebDriver driver;
	public static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		// code for navigating to the URL & maximizing browser
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// First Approach Iframe switch using name or id
		driver.switchTo().frame("classFrame");
		// code for extracting any text from frame1
		element = driver.findElement(By.xpath(
				"//a[text()='com.thoughtworks.selenium' and @href='com/thoughtworks/selenium/package-summary.html']"));
		Thread.sleep(3000);
		String text1 = element.getText();
		System.out.println("Frame1 Extraction = " + text1);

		driver.switchTo().defaultContent();

		// code for extracting any text from frame2
		driver.switchTo().frame("packageListFrame");
		element = driver
				.findElement(By.xpath("//a[contains(text(),'All†Classes') and @href=\"allclasses-frame.html\"]"));
		Thread.sleep(3000);
		String text2 = element.getText();
		System.out.println("Frame1 Extraction = " + text2);
		driver.switchTo().defaultContent();

		// Second Approach Iframe switch using web element
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//frame[@title='Package, class and interface descriptions']")));
		// code for extracting any text from frame1
		element = driver.findElement(By.xpath(
				"//a[text()='com.thoughtworks.selenium' and @href='com/thoughtworks/selenium/package-summary.html']"));
		Thread.sleep(3000);
		String text3 = element.getText();
		System.out.println("Frame1 Extraction = " + text3);

		driver.switchTo().defaultContent();

		// code for extracting any text from frame2
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@title='All Packages']")));
		element = driver
				.findElement(By.xpath("//a[contains(text(),'All†Classes') and @href=\"allclasses-frame.html\"]"));
		Thread.sleep(3000);
		String text4 = element.getText();
		System.out.println("Frame1 Extraction = " + text4);
		driver.switchTo().defaultContent();
		driver.close();
		driver.quit();

	}

}
