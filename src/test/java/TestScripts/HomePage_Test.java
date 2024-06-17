package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Login;

public class HomePage_Test {
	
	WebDriver driver;
	Login l_in;
	HomePage h;
	
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
	
	
    //  Verify_HomePage
	@Test(priority =2)
	public void Verify_HomePage() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		// Header
		h.isApp_Logo_Dispalyed();
		h.isMy_Cart_Enabled();
		h.isOpen_Menu_Btn_Enabled();
		
		// Secondary Header
		h.isProducts_Title_Dispalyed();
		h.isSortBy_Option_Btn_Enabled();
		
		// Inventory_Items
		h.Printing_Inventory_Items();
		
		// Footer_Items
		h.isFooter_Item_Dispalyed();
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
