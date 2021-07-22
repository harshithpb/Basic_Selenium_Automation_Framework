package reuseableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	// get dropdown options as list of string for compare
	public List<String> getDropDownOptionsAsList(WebElement element) {
		Select os = new Select(element);
		List<WebElement> list_webElement_model = os.getOptions();
		List<String> actualContents = new ArrayList<String>();

		for (WebElement ref : list_webElement_model) {
			actualContents.add(ref.getText());
		}
		return actualContents;
	}

	// common method to select option from dropdown
	public void selectDropdownOption(WebElement element, String valueToBeSelected) throws Exception {
		Select os = new Select(element);
		try {
			os.selectByVisibleText(valueToBeSelected);
		} catch (Exception e) {
			throw new Exception("value is not present in dropdown for webElement:" + element
					+ "Value to be selected is: " + valueToBeSelected);
		}
	}

	// for radio button
	public void selectRadioButtonValue(List<WebElement> element, String valueToBeSelected) {
		for (WebElement ref : element) {
			if (ref.getText().equalsIgnoreCase(valueToBeSelected)) {
				ref.click();
				break;
			}

		}
	}

	// for selecting single/multiple check_box
	public void selectCheckBoxes(List<WebElement> element, String checks) {
		String[] checksArray = checks.split(",");
		for (String str : checksArray) {
			for (WebElement ele : element) {
				if (ele.getText().equalsIgnoreCase(str)) {
					ele.click();
					break;
				}
			}
		}
	}

}
