package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Base {

	public static WebDriver driver = null;
	public Properties prop = null;

	public WebDriver initializeBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\nutan\\E2EProjectP\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F://Selenium Workplace//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else {
			driver = new InternetExplorerDriver();

		}
		return driver;
	}
	
	@Test
	public void screenShotTest(String result) throws IOException
	{
	File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	FileUtils.copyFile(src,new File("F:\\Selenium Workplace\\E2EProject\\"+result+"screenshot.png"));

	}

}
