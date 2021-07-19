package insuaranceCalc_Motorcycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTests_motorcycle extends TestBase{
	
	@Test (enabled = false)
	public void errorMesssage_cylinderField() throws Exception {
		homepage.clickOnMotorCycleLink();
		vehData.enterCylinderCapacity("33333");
		test.log(Status.PASS, "Cylinder Capacity is filled with data: 33333");
		String actualErrorMessage = vehData.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message is not as expected on cyclinder capacity field");
		 	
	}
	@Test (enabled = false)
	public void errorMesssage_cylinderField1() throws Exception {
		homepage.clickOnMotorCycleLink();
		vehData.enterCylinderCapacity("33333");
		test.log(Status.PASS, "Cylinder Capacity is filled with data: 33333");
		String actualErrorMessage = vehData.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 3000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message is not as expected on cyclinder capacity field");
		 	
	}
	@Test (enabled = true)
	public void verifyModelDropdownOptions() {
		//click on motorcycle link 
		homepage.clickOnMotorCycleLink();
		//get dropdown content
		List<String> actualValues =  vehData.getDropdownOption_model() ;
		test.log(Status.INFO, "Actual dd contents for modal dd is: " + actualValues);
		//expected values
		List<String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped", "Motorcycle");
		test.log(Status.INFO, "Expected dd contents for modal dd is: " + expectedValues);
		//compare by assert
		Assert.assertEquals(actualValues, expectedValues, "Error in Dropdown options compare at Modal Dropdown");
		
	}

}
