package com.testing.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.qa.base.TestBase;
import com.testing.qa.pages.AddToCartPage;
import com.testing.qa.pages.HomePage;
import com.testing.qa.pages.LoginPage;
import com.testing.qa.pages.MyAccountPage;

public class AddToCartTest extends TestBase{
	
	
	
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	HomePage homepage;
	AddToCartPage addtocartpage;
	
	public AddToCartTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
	initialization();
	 loginpage = new LoginPage();
	 myaccountpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	homepage= myaccountpage.clickOnHomeButton();
	homepage.clickOnTshirtsLink();
	
	}
	
//	@Test(priority=1)
//	public void verifyHomePageTitleTest(){
//		String homePageTitle = homepage.verifyHomePageTitle();
//	    Assert.assertEquals(homePageTitle, "T-shirts - My Store", "Title is not matched");
//	   
//	    addtocartpage.proceedToCheckout();
		
//	}
	
	@Test
	public void verifyAddToCart() {
	 addtocartpage.addToCart();
	}
	
	
	
	
//	@Test(priority=2)
//	public void verifyAddToCart() {
//		
//	addtocartpage.addToCart();
//		
//	}
//	
//	@Test(priority=3)
//	public void verifyProceedToCheckout() {
//		
//		addtocartpage.proceedToCheckout();
//		
//	}
	
	
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
	}
	
	
	

}
