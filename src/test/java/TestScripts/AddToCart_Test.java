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

public class AddToCart_Test {
	
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
	
	
    //  Verify_Elements_Are_Present
	@Test(priority =2)
	public void Verify_Elements_Are_Present() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		atc = new AddToCart(driver);
		
		atc.isPrimary_AddToCart_Btn_Enabled();
		Thread.sleep(2000);
		
		atc.isBack_to_Products_Btn_Enabled();
		Thread.sleep(2000);

	}
	
	
	
    //  Verify_AddToCart
	@Test(priority =3)
	public void Verify_AddToCart() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		atc = new AddToCart(driver);
		atc.AddToCart_Method();
		
		mc = new MyCart(driver);
		
        mc.clickOn_MyCart();
		mc.Access_MyCart_Items();
	}
	
	
    //  Verify_Primary_AddToCart_Btn_Method
	@Test(priority =4)
	public void Verify_Primary_AddToCart_Btn_Method() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		atc = new AddToCart(driver);
		
		atc.isPrimary_AddToCart_Btn_Enabled();
		atc.Primary_AddToCart_Btn_Method();
		
		mc = new MyCart(driver);
		
        mc.clickOn_MyCart();
		mc.Access_MyCart_Items();
	}
	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


}
