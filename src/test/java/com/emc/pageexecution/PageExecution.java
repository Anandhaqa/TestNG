package com.emc.pageexecution;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emc.basepackage.BaseClass;
import com.emc.pagefactory.HomePage;

public class PageExecution {
	
	
	@Test
	public void esearch() throws IOException {
		BaseClass.url(BaseClass.excelRead(0, 1));
		HomePage hp = new HomePage();
		hp.searchBox.sendKeys("Mobile");
		hp.searchBtn.click();
			}
	
	@BeforeMethod
	public void beforeMethod() {
		BaseClass.blaunch();
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		BaseClass.close();
	}
	
	@Test(enabled=true, priority=-1)
	public void lapsearch() throws IOException {
		BaseClass.url(BaseClass.excelRead(0, 1));
		HomePage hp = new HomePage();
		hp.searchBox.sendKeys("Laptops");
		hp.searchBtn.click();
			}
	
	@Test(priority=1)
	public void swSearch() throws IOException {
		BaseClass.url(BaseClass.excelRead(0, 1));
		HomePage hp = new HomePage();
		hp.searchBox.sendKeys("Smart Watch");
		hp.searchBtn.click();
			}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("DB Connected ");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("DB Disconnected");
	}
	
	
	

}
