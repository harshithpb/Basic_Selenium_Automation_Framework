package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObject;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import reuseableComponents.CommonMethods;
import reuseableComponents.ExcelOperations;

public class ObjectsRepo {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static HomePageObjects homepage;
	public static EnterVehicleDataPageObject vehData;
	public static EnterInsurantDataPageObjects insData;
	public static EnterProductDataPageObjects prodData;
	public static SelectPriceOptionsPageObjects priceOptions;
	public static ExcelOperations excel;
	
	public CommonMethods cm = new CommonMethods();
	
}
