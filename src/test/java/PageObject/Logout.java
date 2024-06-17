package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	WebDriver driver;
	
    public Logout(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------  Repository of Elements ------------------ */
    
    @FindBy(id="user-name") WebElement UserName;
    @FindBy(id="password") WebElement Password;
    @FindBy(id="login-button") WebElement Login_Btn;
    
    @FindBy(id="react-burger-menu-btn") WebElement Open_Menu;
    @FindBy(id="logout_sidebar_link") WebElement LogOut;
    
    
/* --------------------------  Methods  --------------------------- */
    
    // url
    public void url() throws InterruptedException
  	{
  		driver.get("https://www.saucedemo.com/");
  		Thread.sleep(2000);
  	}
    
    
    // Login Page Title should be
    public void Login_Page_Title_should_be(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("We are on  the Login Page");
			System.out.println();
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
    }	    
   
    //  enterUsername
    public void enterUsername(String u)
     {
    	UserName.sendKeys(u);
     }
     
    //  enterPassword
    public void enterPassword(String p)
     {
    	 Password.sendKeys(p);
     }
     
     
    //  clickOnLoginBtn
     public void clickOnLoginBtn() throws InterruptedException
     {
    	 Login_Btn.click();
    	 Thread.sleep(2000);
     }
     
    
     //  LogInMethod
     public void LogInMethod(String u,String p) throws InterruptedException
      {
    	  url();
    	  enterUsername(u);
    	  enterPassword(p);
    	  clickOnLoginBtn();
      }
     
     
     //  clickOnOpen_Menu
     public void clickOnOpen_Menu() throws InterruptedException
     {
    	 Open_Menu.click();
    	 Thread.sleep(2000);
     }
     
     
     //  clickOn_Logout
     public void clickOn_Logout() throws InterruptedException
     {
    	 Actions act=new Actions(driver);
		 act.moveToElement(LogOut).build().perform();
		 Thread.sleep(2000);
    	 
    	 LogOut.click();
    	 Thread.sleep(2000);
    	 System.out.println("Logout");
     }
     
     
     //  After_Logout_PageTitle_ShouldBe
     public void After_Logout_PageTitle_ShouldBe(String expectedTitle) throws InterruptedException 
     {
 		String actualTitle=driver.getTitle();
 		if(expectedTitle.equals(actualTitle)) {
 			System.out.println("We are on  the Login Page");
 			System.out.println();
 			}
 		else
 		{
 			System.out.println("We are not on the desired Page");
 		}
     }	    
     
     
/* ----------  method to verify presence of all menus and links  -------------- */  
     
     public boolean isUsernameFieldDisplayed() {
         return UserName.isDisplayed();
     }
     
     public boolean isPasswordFieldDisplayed() {
         return Password.isDisplayed();
     }
     
     public boolean isLogInBtnDisplayed() {
         return Login_Btn.isDisplayed();
     }
     
     
     public boolean isOpen_Menu_Option_Displayed() {
         return Open_Menu.isDisplayed();
     }
     
     public boolean isLogOut_Option_Displayed() {
         return LogOut.isDisplayed();
     }
     
    
     
  // Added a method to verify presence of all Fields and Buttons
     public boolean areAllFieldsAndButtonsDisplayed() {
         return isUsernameFieldDisplayed() & isPasswordFieldDisplayed() & isLogInBtnDisplayed(); // Added checks for all Fields and Buttons
     }
     

}
