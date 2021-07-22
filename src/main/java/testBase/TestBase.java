package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObject;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import reuseableComponents.PropertiesOperations;


public class TestBase extends ObjectsRepo{



	public void LaunchBrowserAndNavigate() throws Exception {
		//read prop file for browser and URL
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Navigate
		driver.get(url);
	}

	@BeforeMethod
	public void setupMethod() throws Exception {
		LaunchBrowserAndNavigate();
		homepage = new HomePageObjects();
		vehData = new EnterVehicleDataPageObject();
		insData = new EnterInsurantDataPageObjects();
		prodData = new EnterProductDataPageObjects();
		priceOptions = new SelectPriceOptionsPageObjects();
	}

	@AfterMethod
	public void endMethod() {
		driver.close();
	}
}
