package com.inetBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginTest_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("username provided");
		loginPage.setPassword(password);
		logger.info("password provided");
		loginPage.clickLoginButton();

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		} else {
			Assert.assertTrue(true);
			loginPage.clickLogoutLink();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			logger.info("Login Passed");
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String excelFilePath = System.getProperty("user.dir")
				+ "/src/test/java/com/inetBankingV1/testData/LoginTest.xlsx";
		int rowCount = XLUtils.getRowCount(excelFilePath, "Sheet1");
		int columnCount = XLUtils.getCellCount(excelFilePath, "Sheet1", rowCount);
		String loginData[][] = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(excelFilePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}