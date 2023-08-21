package com.emc.pageexecution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.emc.basepackage.BaseClass;
import com.emc.pagefactory.LoginPage;

public class LoginPageExecution {

	@Test(dependsOnMethods = {"checkSignUpLink"})
	public void testLoginFunction() {
		LoginPage lp = new LoginPage();
		lp.userName.sendKeys("anandh@gmail.com");
		lp.passWord.sendKeys("Welcome@123");
		//lp.passWord.sendKeys(pwd);
		System.out.println("Login Function");
		lp.loginBtn.click();
	}
	
	@Test(description="Check the Method",invocationCount=2)
	public void helloMsg() {
		System.out.println("Hello");
	}


	@Test(enabled=true)
	public void checkSignUpLink() {
		LoginPage lp1 = new LoginPage();
		lp1.signupLink.click();
		System.out.println("Singup Link Check");
//		Assert.assertTrue(false);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		BaseClass.blaunch();
		BaseClass.url("https://www.facebook.com/");
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		BaseClass.close();
		System.out.println("After Method");
	}
	
	@BeforeClass(alwaysRun=true)
	public static void beforeClass() {
		System.out.println("Before Class - DB Connection Open");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class - DB Connection Close");
	}
	
//@Test(dataProvider = "testData")
//public void testMethod(String name) {
		//System.out.println(name);
	//}
	
	@DataProvider(name = "testData")
	public Object[][] data() {
		
//		Object[][] obj = new Object[2][2];
//		obj[0][0]="Rizwan";
//		obj[0][1]=12345;
//		obj[1][0]="Gishow";
//		obj[1][1]=12346;
//		
//		return obj;
		
		return new Object[][] {
			   { "rizwan@gmail.com", "Test@123" },
			   { "gishow@gamil.com", "Welcome@12" },
			 };

	}
}
