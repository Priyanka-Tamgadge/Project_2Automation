package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
    public HomePage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------  Repository of Elements ------------------ */
    
    
    // Header 
    @FindBy(xpath="//div[@class='app_logo']") WebElement App_Logo;
    @FindBy(xpath="//a[@class='shopping_cart_link']") WebElement My_Cart;
    @FindBy(id="react-burger-menu-btn") WebElement Open_Menu_Btn;
    
    
    // Secondary Header
    @FindBy(xpath="//div[@class='header_secondary_container']/child::span") WebElement Products_Title;
    @FindBy(xpath="//span[@class='active_option']") WebElement SortBy_Option;
    
    
    // Inventory_Items
    @FindBy(xpath="//div[@class='inventory_item_name ']") List<WebElement> Inventory_Items;
    
    
    // Footer
    @FindBy(xpath="//ul[@class='social']/child::li") List<WebElement> Social_Handles;
    @FindBy(xpath="//div[@class='footer_copy']") WebElement Footer_Copy;
    
    

/* --------------------------  Methods  --------------------------- */   
    
  
    
    //  HomePage_Title_ShouldBe
    public void HomePage_Title_ShouldBe(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("We are on  the HomePage Page");
			System.out.println();
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
		
    }
    
    
    //  isApp_Logo_Dispalyed
    public void isApp_Logo_Dispalyed()
    {
    	if(App_Logo.isDisplayed())
    	{
    		System.out.println("* App Logo is Present:   "+App_Logo.getText()+"\n");
    	}
    }
    
    
    //  isMy_Cart_Enabled
    public void isMy_Cart_Enabled()
    {
    	if(My_Cart.isEnabled())
    	{
    		System.out.println("* My_Cart is Enabled \n");
    	}
    }
    
    
    //  isOpen_Menu_Btn_Enabled
    public void isOpen_Menu_Btn_Enabled()
    {
    	if(Open_Menu_Btn.isEnabled())
    	{
    		System.out.println("* Open_Menu_Btn is Enabled \n");
    	}
    }
    
   
    //  isProducts_Title_Dispalyed 
    public void isProducts_Title_Dispalyed()
    {
    	if(Products_Title.isDisplayed())
    	{
    		System.out.println("* Products_Title is Present:   "+Products_Title.getText()+"\n");
    	}
    }
    
    
    //  isSortBy_Option_Btn_Enabled
    public void isSortBy_Option_Btn_Enabled()
    {
    	if(SortBy_Option.isEnabled())
    	{
    		System.out.println("* SortBy_Option is Enabled \n");
    	}
    }
    
    
    //  Printing_Inventory_Items
    public void Printing_Inventory_Items()
    {
    	System.out.println("* Inventory Items are: ");
    	
    	for(int i=0;i<Inventory_Items.size();i++)
    	{
    		System.out.println(Inventory_Items.get(i).getText());
    	}
    	
    	System.out.println();
    }
    
   
    //   isFooter_Item_Dispalyed
    public void isFooter_Item_Dispalyed()
    {
    	System.out.println("* Social_Handles: ");
    	for(int i=0;i<Social_Handles.size();i++)
    	{
    		System.out.println(Social_Handles.get(i).getText());
    	}
    	
    	System.out.println();
    	if(Footer_Copy.isDisplayed())
    	{
    		System.out.println("* Footer_Copy: "+Footer_Copy.getText()+"\n");
    	}
    } 
    
   

}
