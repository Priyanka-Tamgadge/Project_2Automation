package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.Login;
import PageObject.Logout;

public class Logout_Test {
	
	WebDriver driver;
	Login l_in;
	Logout l_out;
	
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
	
	
    //  Verify_Logout_Process
	@Test(priority =2)
	public void Verify_Logout_Process() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		l_out = new Logout(driver);
		
		l_out.isOpen_Menu_Option_Displayed();
		l_out.clickOnOpen_Menu();
		
		l_out.isLogOut_Option_Displayed();
		l_out.clickOn_Logout();
		
		l_out.After_Logout_PageTitle_ShouldBe("Swag Labs");
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
