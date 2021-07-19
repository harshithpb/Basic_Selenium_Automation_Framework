package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOptionsPageObjects extends TestBase {
	
	@FindBy(id="nextsendquote")
	WebElement btn_nxt;
	
	
	//init
	public SelectPriceOptionsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	//to get price based on selected 
	public String getPriceForSelectedOption(String plan) {
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+ plan +"']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
		
	}
	
	public void SelectPriceOption(String plan) {
		String datapath = "//input[@name='Select Option' and @value='"+ plan +"']/parent::label";
		driver.findElement(By.xpath(datapath)).click();
	}
	
	public void clickOnNextButton() {
		btn_nxt.click();
	}

}
