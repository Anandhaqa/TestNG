package com.emc.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emc.basepackage.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(xpath="//input[@value='Go']")
	public WebElement searchBtn;

}
