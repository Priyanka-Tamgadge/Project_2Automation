package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.AddToCart;
import PageObject.HomePage;
import PageObject.Login;
import PageObject.MyCart;


public class MyCart_Test {
	
	WebDriver driver;
	Login l_in;
	HomePage h;
	MyCart mc;
	AddToCart atc;
	
	
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
	
	
    //  Verify_MyCart
	@Test(priority =2)
	public void Verify_MyCart() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		mc = new MyCart(driver);
		
		mc.isMy_Cart_Enabled();
		mc.clickOn_MyCart();
		mc.isQuantity_Label_Dispalyed();
		mc.isDescription_Label_Dispalyed();
		mc.isContinue_shopping_Btn_Enabled();
		mc.isCheckout_Btn_Enabled();
		
		//mc.ClickOn_All_Items();
	}
	
	
    //  Verify_Accessing_MyCart_Items
	@Test(priority =3)
	public void Verify_Accessing_MyCart_Items() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		atc = new AddToCart(driver);
		atc.AddToCart_Method();
		
		mc = new MyCart(driver);
		
		mc.isMy_Cart_Enabled();
		mc.clickOn_MyCart();
		
		mc.Access_MyCart_Items();
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
