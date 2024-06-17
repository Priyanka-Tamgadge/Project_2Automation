package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Login;
import PageObject.SortBy;

public class SortBy_Test {
	
	WebDriver driver;
	Login l_in;
	HomePage h;
	SortBy sb;
	
	
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
		public void Verify_Available_SortBy_Options() throws InterruptedException
		{
			l_in.LogInMethod("standard_user", "secret_sauce");
			
			h = new HomePage(driver);
			h.HomePage_Title_ShouldBe("Swag Labs");
			
			sb = new SortBy(driver);
			
			sb.isSortByBtn_Enabled();
			sb.ClickOn_SortBy();
			
			sb.Check_SortBy_Options();
		}
	
		
	//  Verify_SortBy_Name_Z_to_A
		@Test(priority =3)
		public void Verify_SortBy_Name_Z_to_A() throws InterruptedException
		{
			l_in.LogInMethod("standard_user", "secret_sauce");
			
			h = new HomePage(driver);
			h.HomePage_Title_ShouldBe("Swag Labs");
			
			sb = new SortBy(driver);
			
			sb.isSortByBtn_Enabled();
			sb.ClickOn_SortBy();
			
			sb.Check_SortBy_Name_Z_to_A();
			Thread.sleep(2000);
			
		}
		
		
	//  Verify_SortBy_Name_A_to_Z
		@Test(priority =4)
		public void Verify_SortBy_Name_A_to_Z() throws InterruptedException
		{
			l_in.LogInMethod("standard_user", "secret_sauce");
			
			h = new HomePage(driver);
			h.HomePage_Title_ShouldBe("Swag Labs");
			
			sb = new SortBy(driver);
			
			sb.isSortByBtn_Enabled();
			sb.ClickOn_SortBy();
			
			sb.Check_SortBy_Name_A_to_Z();
			Thread.sleep(2000);
		}
		
		
	//  Verify_SortBy_Price_low_to_high
		@Test(priority =5)
		public void Verify_SortBy_Price_low_to_high() throws InterruptedException
		{
			l_in.LogInMethod("standard_user", "secret_sauce");
			
			h = new HomePage(driver);
			h.HomePage_Title_ShouldBe("Swag Labs");
			
			sb = new SortBy(driver);
			
			sb.isSortByBtn_Enabled();
			sb.ClickOn_SortBy();
			
			sb.Check_SortBy_Price_low_to_high();
			Thread.sleep(2000);
		}
		
		
		
	//  Verify_SortBy_Price_high_to_low
		@Test(priority =6)
		public void Verify_SortBy_Price_high_to_low() throws InterruptedException
		{
			l_in.LogInMethod("standard_user", "secret_sauce");
			
			h = new HomePage(driver);
			h.HomePage_Title_ShouldBe("Swag Labs");
			
			sb = new SortBy(driver);
			
			sb.isSortByBtn_Enabled();
			sb.ClickOn_SortBy();
		
			sb.Check_SortBy_Price_high_to_low();
			Thread.sleep(2000);
		}
		
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
