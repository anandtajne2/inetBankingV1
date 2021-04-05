package com.inetBankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("URL is opened");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("Entered username");
		loginPage.setPassword(password);
		logger.info("Entered password");
		loginPage.clickLoginButton();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test pass");
		} else {
			captureScreen(driver, "loginTest");
			logger.info("screenshot taken");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}