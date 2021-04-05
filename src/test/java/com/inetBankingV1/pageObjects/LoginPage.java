package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	// a[text()='Log out']
	@FindBy(xpath = "//a[text()='Log out']")
	@CacheLookup
	WebElement logOutLink;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void setUserName(String userName) {
		txtUserName.sendKeys(userName);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLoginButton() {
		btnLogin.click();
	}

	public void clickLogoutLink() {
		logOutLink.click();
	}

}
