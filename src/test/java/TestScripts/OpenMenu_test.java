package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Login;
import PageObject.OpenMenu;

public class OpenMenu_test {
	
	WebDriver driver;
	Login l_in;
	HomePage h;
	OpenMenu m;
	
	
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
	
	
    //  Verify_Options_Inside_Menu
	@Test(priority =2)
	public void Verify_Options_Inside_Menu() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		m = new OpenMenu(driver);
		
		m.clickOn_Open_Menu_Btn();
		m.Verify_Options_Inside_Menu();
		m.close_Open_Menu();
	}
	
	
    //  Verify_All_Items_Menu
	@Test(priority =3)
	public void Verify_All_Items_Menu() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		m = new OpenMenu(driver);
		
		//m.clickOn_Open_Menu_Btn();
		m.Check_All_Items();
		Thread.sleep(2000);
	}
	
	
    //  Verify_About_Menu
	@Test(priority =4)
	public void Verify_About_Menu() throws InterruptedException
	{
		l_in.LogInMethod("standard_user", "secret_sauce");
		
		h = new HomePage(driver);
		h.HomePage_Title_ShouldBe("Swag Labs");
		
		m = new OpenMenu(driver);
		
		m.clickOn_Open_Menu_Btn();
		m.ClickOn_About();
		m.About_Page_Title_ShouldBe("Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}


}
