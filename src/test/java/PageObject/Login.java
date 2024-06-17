package PageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	 WebDriver driver;
		
	    public Login(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}
	    
	    
/* -----------------  Repository of Elements ------------------ */
	    
	    @FindBy(id="user-name") WebElement UserName;
	    @FindBy(id="password") WebElement Password;
	    @FindBy(id="login-button") WebElement Login_Btn;
	    
	    @FindBy(xpath="//div[@class='login_credentials']") WebElement Accepted_Username_List;
	    @FindBy(xpath="//div[@class='login_password']") WebElement Password_List;
	    
	    @FindBy(xpath="//div[@class='error-message-container error']/child::h3") WebElement Error_Msg;
	   

	    
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
	    public void enterUsername(String u) throws InterruptedException
	     {
	    	UserName.sendKeys(u);
	    	Thread.sleep(1000);
	     }
	     
	    
	    //  enterPassword
	    public void enterPassword(String p) throws InterruptedException
	     {
	    	 Password.sendKeys(p);
	    	 Thread.sleep(1000);
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
	     
	     
	     // Accepted_Usernames_Are
	     public void Accepted_Usernames_Are()
	     {
	         String divText = Accepted_Username_List.getText();
	         System.out.println(divText);
	         System.out.println();
	     }
	     
	     
	     // Accepted_Password_is
	     public void Accepted_Password_is()
	     {
	    	 String divText = Password_List.getText();
	         System.out.println(divText);
	         System.out.println();
	     }
	     
	    
	     //  LogIn_With_BlanckDetails
	     public void LogIn_With_BlankDetails(String u,String p) throws InterruptedException
	     {
	    	 enterUsername(u);
	    	 enterPassword(p);
	    	 clickOnLoginBtn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(UserName.getText()=="" || Password.getText()=="")
	    	 {
	    		 System.out.println("Error Message For Blank Details:        \n"+Error_Msg.getText());
	    		 System.out.println();
	    	 }
	     }
	     
	     
	 //  LogIn_With_Blank_UserName
	     public void LogIn_With_Blank_UserName(String u,String p) throws InterruptedException
	     {
	    	 enterUsername(u);
	    	 enterPassword(p);
	    	 clickOnLoginBtn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(UserName.getText()=="" || Password.getText()=="")
	    	 {
	    		 System.out.println("Error Message For Blank UserName:        \n"+Error_Msg.getText());
	    		 System.out.println();
	    	 }
	     }
	     
	     
	     //  LogIn_With_Blank_Password
	     public void LogIn_With_Blank_Password(String u,String p) throws InterruptedException
	     {
	    	 enterUsername(u);
	    	 enterPassword(p);
	    	 clickOnLoginBtn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(UserName.getText()=="" || Password.getText()=="")
	    	 {
	    		 System.out.println("Error Message For Blank Password:        \n"+Error_Msg.getText());
	    		 System.out.println();
	    	 }
	     }
	     
	     
	     //  LogIn_With_Invalid_Credentials
	     public void LogIn_With_Invalid_Credentials(String u,String p) throws InterruptedException
	     {
	    	 enterUsername(u);
	    	 enterPassword(p);
	    	 clickOnLoginBtn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(UserName.getText()!="standard_user" || Password.getText()!="secret_sauce")
	    	 {
	    		 System.out.println(Error_Msg.getText());
	    		 System.out.println();
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
	     
	     public boolean isAccepted_Username_List_Displayed() {
	         return Accepted_Username_List.isDisplayed();
	     }
	     
	     public boolean isPassword_List_Displayed() {
	         return Password_List.isDisplayed();
	     } 
	     
	  // Added a method to verify presence of all Fields and Buttons
	     public boolean areAllFieldsAndButtonsDisplayed() {
	         return isUsernameFieldDisplayed() & isPasswordFieldDisplayed() & isLogInBtnDisplayed() & 
	        		 isAccepted_Username_List_Displayed() & isPassword_List_Displayed(); // Added checks for all Fields and Buttons
	     }

}
