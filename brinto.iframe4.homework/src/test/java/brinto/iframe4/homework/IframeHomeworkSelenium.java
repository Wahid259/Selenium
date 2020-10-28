package brinto.iframe4.homework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

public class IframeHomeworkSelenium {
	public static WebDriver driver;
	public static WebElement element;
	public static String browser;
	public static int expectedFrame = 3;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		if (browser.contains("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		// For Safari Browser
		if (browser.contains("Safari")) {

			System.setProperty("webdriver.chrome.driver", "/usr/bin/safaridriver");
			driver = new ChromeDriver();
		}
		// For Windows Browser
		if (browser.contains("ChromeWindows")) {

			System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// maximize window
		driver.manage().window().maximize();

		int iframeCount = driver.findElements(By.tagName("frame")).size();
		// System.out.println(iframeCount);

		if (iframeCount == expectedFrame) {
			AssertJUnit.assertTrue(true);
			System.out.println("Total Frame count = " + iframeCount);
		} else {
			System.out.println("Total Frame count = " + iframeCount);
			AssertJUnit.fail();
		}
		// by name
		driver.switchTo().frame("packageListFrame");
		// get the text
		element = driver.findElement(By.xpath("//a[@href='allclasses-frame.html']"));
		Thread.sleep(5000);
		String text1 = element.getText();
		System.out.println("Frame 1 Extraction = " + text1);

		driver.switchTo().defaultContent();

		// by name
		driver.switchTo().frame("classFrame");
		// get the text
		element = driver.findElement(By.xpath("//a[@href='com/thoughtworks/selenium/package-summary.html']"));
		Thread.sleep(5000);
		String text2 = element.getText();
		System.out.println("Frame 2 Extraction = " + text2);

		driver.switchTo().defaultContent();

		// driver.close();
		// driver.quit();

	}

}
