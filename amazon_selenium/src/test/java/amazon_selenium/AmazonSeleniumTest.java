package amazon_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSeleniumTest {
	static String browser;
	static WebDriver driver;


public static void main(String[] args) {
	
	setBrowser();
	setBrowserConfig();
	runTest();


}



public static void setBrowser() {
	
	browser = "Chrome";
}

public static void setBrowserConfig() {
	
	if (browser.contains("Chrome")){
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
	}
	if (browser.contains("Safari")){
		
		System.setProperty("webdriver.chrome.driver","/usr/bin/safaridriver");
		driver = new ChromeDriver();
	}
}

public static void runTest() {
	
//	browser = "Chrome";
	driver.get("https://amazon.com/");
}

}
