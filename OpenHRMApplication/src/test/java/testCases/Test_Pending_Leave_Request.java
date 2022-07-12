package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.Dashboard_Page_Objects;
import pageObjects.Login_Page_Objects;

public class Test_Pending_Leave_Request extends CommonFunctions {
	
	String actualMessage;
	
	static Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
	public void login() {
		logger.info("Logging into the Application");
		PageFactory.initElements(driver, Login_Page_Objects.class);	
		Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));	
		Login_Page_Objects.passWord.sendKeys(properties.getProperty("password"));	
		Login_Page_Objects.submitButton.click();
	}
	
	public void getPendingLeaveRequest() {
		PageFactory.initElements(driver, Dashboard_Page_Objects.class);
		actualMessage = Dashboard_Page_Objects.pendingLeaveRequests.getText();

	}

	@Test
	public void verifyPendingLeaveRequest() {
		login();
		logger.info("Getting the Pending Leave Request Details");
		getPendingLeaveRequest();

		logger.info("Verification");
		Assert.assertEquals(actualMessage, "No Records are Available");

		logger.info("End of Test_Pending_Leave_Request");
	}
}
