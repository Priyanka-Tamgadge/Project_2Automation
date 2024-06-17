package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.Login;


public class Login_Test {
	
	WebDriver driver;
	Login l;
	
	//  launchBrowser
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		l = new Login(driver);
		Thread.sleep(3000);
	}
	
	
	//  Verify_LogIn_Page_Title
	@Test(priority =1)
	public void Verify_LogIn_Page_Title() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		l.areAllFieldsAndButtonsDisplayed();
	}
	
	
   //  LogIn_Process
	@Test(priority =2)
	public void Verify_LogIn_Process() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		l.Accepted_Usernames_Are();
		l.Accepted_Password_is();
		l.enterUsername("standard_user");
		l.enterPassword("secret_sauce");
		l.clickOnLoginBtn();
	}  
	
	
    //  LogIn_With_BlankDetails
	@Test(priority =3)
	public void Verify_LogIn_With_BlankDetails() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		l.LogIn_With_BlankDetails("","");
		
	}  
	
	
	
    //  LogIn_With_Blank_UserName
	@Test(priority =4)
	public void Verify_LogIn_With_Blank_UserName() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		l.LogIn_With_Blank_UserName("","secret_sauce");
	}  
	
	
	
    //  LogIn_With_Blank_Password
	@Test(priority =5)
	public void Verify_LogIn_With_Blank_Password() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		l.LogIn_With_Blank_Password("standard_user","");
	}  
	
	
    //  Verify_LogIn_With_Invalid_UserName_Password
	@Test(priority =6)
	public void Verify_LogIn_With_Invalid_UserName_Password() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		System.out.println("Message for Invalid Username and Password:");
		l.LogIn_With_Invalid_Credentials("abc","pqr");
	}  
	
	
    //  Verify_LogIn_With_InvalidUserName_ValidPassword
	@Test(priority =7)
	public void Verify_LogIn_With_InvalidUserName_ValidPassword() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		System.out.println("Message for Invalid Username and  Valid Password:");
		l.LogIn_With_Invalid_Credentials("abc","secret_sauce");
	}  
	
	
    //  Verify_LogIn_With_ValidUserName_InvalidPassword
	@Test(priority =8)
	public void Verify_LogIn_With_ValidUserName_InvalidPassword() throws InterruptedException
	{
		l.url();
		l.Login_Page_Title_should_be("Swag Labs");
		System.out.println("Message for Valid Username and Invalid Password:");
		l.LogIn_With_Invalid_Credentials("standard_user","pqr");
	}  
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
