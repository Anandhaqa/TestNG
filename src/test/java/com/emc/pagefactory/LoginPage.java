package com.emc.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emc.basepackage.BaseClass;

public class LoginPage extends BaseClass{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	public WebElement userName;
	
	@FindBy(id="pass")
	public WebElement passWord;
	
	@FindBy(xpath="//button[@name='login']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	public WebElement signupLink;

}
