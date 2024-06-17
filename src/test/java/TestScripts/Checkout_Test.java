package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.AddToCart;
import PageObject.Checkout;
import PageObject.HomePage;
import PageObject.Login;
import PageObject.MyCart;

public class Checkout_Test {
	
	WebDriver driver;
	Login l_in;
	HomePage h;
	MyCart mc;
	AddToCart atc;
	Checkout c;
	
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		l_in = new Login(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_LogIn_Page_Title
	@Test(priority =1)
	public void Verify_LogIn_Page_Title() throws InterruptedException
	{
		l_in.url();
		l_in.Login_Page_Title_should_be("Swag Labs");
		l_in.areAllFieldsAndButtonsDisplayed();
	}
	
	
//  Verify_Checkout_Process
	@Test(priority =2)
	public void Verify_Checkout_Process() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		atc = new AddToCart(driver);
		atc.AddToCart_Method();
		
		mc = new MyCart(driver);
		mc.clickOn_MyCart();
		mc.Access_MyCart_Items();
		
		//  
		c = new Checkout(driver);
		c.clickOn_Checkout_Btn();
		
		//  Checkout: Your Information
		c.enter_Your_Information("Draco", "Malfoy", "123456");
		
		//  Checkout: Overview
		c.Access_Checkout_Items();
		c.Access_Payment_Infirmation();
		c.Access_Shipping_Infirmation();
		c.Access_Price_Infirmation();
		c.Access_Total_Infirmation();
		c.clickOn_Finish_Btn();
		
		//  Checkout: Complete!  
		c.Access_Success_Msg();
		c.isBackHome_Btn_Enabled();
		
	}
	
	
    //  Verify_Error_Msg_Fir_Blank_Details
	@Test(priority =3)
	public void Verify_Error_Msg_Fir_Blank_Details() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		atc = new AddToCart(driver);
		atc.AddToCart_Method();
		
		mc = new MyCart(driver);
		mc.clickOn_MyCart();
		mc.Access_MyCart_Items();
		
		//  
		c = new Checkout(driver);
		c.clickOn_Checkout_Btn();
		
		//  Checkout: Your Information
		System.out.println("Message for blank FirstName, LastName, PostalCode: ");
		c.Error_Message_Blank_Details("", "", "");
		
		System.out.println("Message for blank LastName,: ");
		c.Error_Message_Blank_Last_Name("Draco", "", "123456");
		
		System.out.println("Message for blank PostalCode: ");
		c.Error_Message_Blank_Postal_Code("Draco", "Malfoy", "");
		
		System.out.println("Message for blank FirstName: ");
		c.Error_Message_Blank_First_Name("", "Malfoy", "123456");
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
