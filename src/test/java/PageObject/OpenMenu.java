package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMenu {
	
    WebDriver driver;
	
    public OpenMenu(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------  Repository of Elements ------------------ */
    
     
    @FindBy(id="react-burger-menu-btn") WebElement Open_Menu_Btn;
    @FindBy(xpath="//nav[@class='bm-item-list']/child::a") List<WebElement> Options_Inside_Menu;
    @FindBy(id="react-burger-cross-btn") WebElement Close_Btn;
    
    @FindBy(xpath="//a[@id='inventory_sidebar_link']") WebElement All_Items;
    @FindBy(xpath="//a[@id='item_4_title_link']") WebElement Product;
    
    @FindBy(xpath="//a[@id='about_sidebar_link']") WebElement About;
    
    
/* --------------------------  Methods  --------------------------- */ 
    
    
    //  clickOn_Open_Menu_Btn
    public void clickOn_Open_Menu_Btn() throws InterruptedException
    {
    	Open_Menu_Btn.click();
    	Thread.sleep(2000);
    }
    
    
    //  Verify_Options_Inside_Menu
    public void Verify_Options_Inside_Menu() throws InterruptedException
    {
    	for(int i=0;i<Options_Inside_Menu.size();i++)
    	{
    		Actions act=new Actions(driver);
   		    act.moveToElement(Options_Inside_Menu.get(i)).build().perform();
   		    Thread.sleep(1000);
   		    
   		    System.out.println(Options_Inside_Menu.get(i).getText());
    	}
    }
    
    //  close_Open_Menu
    public void close_Open_Menu() throws InterruptedException
    {
    	Close_Btn.click();
    	Thread.sleep(2000);
    }
    
    
    //  clickOn_All_Items
    public void Check_All_Items() throws InterruptedException
    {
    	Actions act=new Actions(driver);
    	
    	act.moveToElement(Product).build().perform();
    	Thread.sleep(2000);
    	Product.click();
    	Thread.sleep(1000);
    	
    	Open_Menu_Btn.click();
    	Thread.sleep(2000);
    	
    	act.moveToElement(All_Items).build().perform();
    	Thread.sleep(2000);
    	All_Items.click();
    	Thread.sleep(1000);;
    }
    
    
    //  ClickOn_About
    public void ClickOn_About() throws InterruptedException
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(All_Items).build().perform();
    	Thread.sleep(1000);
    	
    	About.click();
    	Thread.sleep(2000);
    }
    
    
    //  About_Page_Title_ShouldBe
    public void About_Page_Title_ShouldBe(String expectedTitle) throws InterruptedException 
    {
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("We are on  the About Page");
			System.out.println(expectedTitle);
			System.out.println();
			}
		else
		{
			System.out.println("We are not on the desired Page");
		}
		
    }
    
    
    
    
    
    
    
    

}
