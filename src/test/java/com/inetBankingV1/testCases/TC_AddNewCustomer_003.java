package com.inetBankingV1.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.AddCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddNewCustomer_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickLoginButton();
		Thread.sleep(2000);

		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		addCustomerPage.clickLinkAddNewCustomer();
		addCustomerPage.setName("anand");
		addCustomerPage.setGender("male");
		addCustomerPage.setTxtDOB("11", "12", "1988");
		Thread.sleep(2000);
		addCustomerPage.setAddress("INDIA");
		addCustomerPage.setCity("PUNE");
		addCustomerPage.setState("MAHARASHTRA");
		addCustomerPage.setPinno("411058");
		addCustomerPage.setTelephoneno("8888888888");
		addCustomerPage.setEmailid(randomString() + "@gmail.com");
		addCustomerPage.setPassword("helloTester");
		Thread.sleep(2000);
		addCustomerPage.clickSubmit();
		Thread.sleep(2000);

		logger.info("validation started...");
		boolean register = driver.getPageSource().contains("Customer Registered Successfully!!");
		if (register == true) {
			Assert.assertTrue(true);
			logger.info("add new customer test passed");
		} else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("add new customer test failed");
		}
	}

	public String randomString() {
		return RandomStringUtils.randomAlphanumeric(8);
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(8);
		return (generatedNumber);
	}

}