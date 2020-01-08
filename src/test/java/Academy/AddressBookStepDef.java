package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import PageObjects.AddressBookLocators;
import resources.Base;

public class AddressBookStepDef extends Base {

	public static Logger logger = LogManager.getLogger(AddressBookStepDef.class.getName());

	public AddressBookStepDef() throws IOException {
		super();
	}

	@Test
	public void Credentials() throws IOException {
		driver = initializeBrowser();
		driver.get("http://a.testaddressbook.com/sign_in");
		driver.findElement(AddressBookLocators.username).sendKeys("admin20@gmail.com");
		driver.findElement(AddressBookLocators.password).sendKeys("123");
		driver.findElement(AddressBookLocators.Submit).click();

		logger.info("working successfully");
		logger.debug("working successfully");
		logger.error("working successfully");
	}

	@Test(dependsOnMethods = "Credentials")
	public void getTitleText() {
		Assert.assertEquals(driver.getTitle(), "Addressss78 Book");

	}

	@AfterClass
	public void windwClose() {
		driver.quit();
	}

}
