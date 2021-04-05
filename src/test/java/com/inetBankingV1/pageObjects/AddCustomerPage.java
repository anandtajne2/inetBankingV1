package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	@CacheLookup
	WebElement linkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement txtGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDOB;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinno;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailid;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement submit;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLinkAddNewCustomer() {
		linkAddNewCustomer.click();
	}

	public void setName(String name) {
		txtName.sendKeys(name);
	}

	public void setGender(String gender) {
		txtGender.click();
	}

	public void setTxtDOB(String dd, String mm, String yy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}

	public void setAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void setCity(String city) {
		txtCity.sendKeys(city);
	}

	public void setState(String state) {
		txtState.sendKeys(state);
	}

	public void setPinno(String pinno) {
		txtPinno.sendKeys(pinno);
	}

	public void setTelephoneno(String telephoneno) {
		txtTelephoneno.sendKeys(telephoneno);
	}

	public void setEmailid(String emailid) {
		txtEmailid.sendKeys(emailid);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickSubmit() {
		submit.click();
	}

}
