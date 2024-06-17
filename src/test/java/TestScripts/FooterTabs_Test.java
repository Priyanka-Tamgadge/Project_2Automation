package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.FooterTabs;
import PageObject.HomePage;
import PageObject.Login;

public class FooterTabs_Test {
	

	WebDriver driver;
	Login l_in;
	HomePage h;
	FooterTabs f;
	
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
	
	
    //  Verify_Twitter_Link
	@Test(priority =2)
	public void Verify_Twitter_Link() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		f = new FooterTabs(driver);
		f.isTwitter_Link_Enabled();
		f.clickOn_Twitter_Link();
	}
		


    //  Verify_Facebook_Link
	@Test(priority =3)
	public void Verify_Facebook_Link() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		f = new FooterTabs(driver);
		f.isFacebook_Link_Enabled();
		f.clickOn_Facebook_Link();
	}
	
	
    //  Verify_Linkedin_Link
	@Test(priority =4)
	public void Verify_Linkedin_Link() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		f = new FooterTabs(driver);
		f.isLinkedin_Link_Enabled();
		f.clickOn_Linkedin_Link();
	}
	
	
    //  Verify_isFooter_Copy_Dispalyed
	@Test(priority =5)
	public void Verify_isFooter_Copy_Dispalyed() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		f = new FooterTabs(driver);
		f.isFooter_Copy_Dispalyed();
	}
	

	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


}
