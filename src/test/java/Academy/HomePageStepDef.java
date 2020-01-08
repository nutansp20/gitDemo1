package Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.MercuryToursLocators;
import resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePageStepDef extends Base{
public static Logger logger=LogManager.getLogger(HomePageStepDef.class.getName());
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
public HomePageStepDef() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test(dataProvider="getData")
public void homeTest(String username,String password) throws IOException
{
	logger.info("working successfully");
	logger.debug("working successfully");
	logger.error("working successfully");
	driver = initializeBrowser();
	driver.get(prop.getProperty("URL"));
	driver.findElement(MercuryToursLocators.username).sendKeys(username);
	driver.findElement(MercuryToursLocators.password).sendKeys(password);
	driver.findElement(MercuryToursLocators.signin).click();
}
@DataProvider
public Object[][] getData() throws NumberFormatException, IOException
{
	System.out.println("Enter Rows");
	int row = Integer.parseInt(br.readLine());
	System.out.println("Enter Column");
	int column = Integer.parseInt(br.readLine());
	Object[][] o = new Object[row][column];
	for(int i=0;i<row;i++)
	{System.out.println("enter the username and Password"+(i+1));
		for(int j=0;j<column;j++)
		{ o[i][j]=br.readLine();		}
	}return o;	
}
@AfterClass
public void windwClose()
{
driver.quit();	
}
}
