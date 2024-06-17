package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	
    WebDriver driver;
	
    public AddToCart(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------  Repository of Elements ------------------ */
    
 
    @FindBy(id="add-to-cart") WebElement AddToCart_Btn;
    @FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory ']") List<WebElement> Primary_AddToCart_Btn;
    @FindBy(xpath="//div[@class='inventory_item_name ']") List<WebElement> Product_Name;
    @FindBy(id="back-to-products") WebElement Back_to_Products_Btn;
    @FindBy(id="remove") WebElement Remove_Btn;
    @FindBy(xpath="//a[@class='shopping_cart_link']") WebElement MyCart_Link;
    
    
/* --------------------------  Methods  --------------------------- */ 
    

    
    //  isPrimary_AddToCart_Btn_Enabled
    public void isPrimary_AddToCart_Btn_Enabled()
    {
    	for(int i=0;i<Product_Name.size();i++)
    	{
    		if(Primary_AddToCart_Btn.get(i).isEnabled())
        	{
        		System.out.println("* Primary_AddToCart_Btn is Enabled for "+Product_Name.get(i).getText());
        	}
    	}
    	
    }
    
    //  isBack_to_Products_Btn_Enabled
    public void isBack_to_Products_Btn_Enabled() throws InterruptedException
    {
    	System.out.println();
    	for(int i=0;i<Product_Name.size();i++)
    	{
    		Product_Name.get(i).click();
    		Thread.sleep(2000);
    		if(Back_to_Products_Btn.isEnabled())
        	{
        		System.out.println("* Back_to_Products_Btn is Enabled: "+Back_to_Products_Btn.getText());
        		System.out.println();
        	}
    	}
    	
    }
    
    
   //   isAddToCart_Btn_Enabled
    public void isAddToCart_Btn_Enabled() throws InterruptedException
    {
    	for(int i=0;i<Product_Name.size();i++)
    	{
    		Product_Name.get(i).click();
    		Thread.sleep(2000);
    		if(AddToCart_Btn.isEnabled())
        	{
        		System.out.println("* AddToCart_Btn is Enabled for "+Product_Name.get(i).getText());
        	}
    	}
    	
    }
    
    
    //  AddToCart_Method
    public void AddToCart_Method() throws InterruptedException
    {
    	Actions act=new Actions(driver);
    	for(int i=0;i<=2;i++)
    	{
    		act.moveToElement(Product_Name.get(i)).build().perform();
    		Thread.sleep(1000);
    		Product_Name.get(i).click();
    		Thread.sleep(2000);
    		
    		AddToCart_Btn.click();
    		Thread.sleep(2000);
    		
   		    act.moveToElement(Back_to_Products_Btn).build().perform();
   		    Thread.sleep(1000);
    		Back_to_Products_Btn.click();
    		Thread.sleep(2000);
    	}
    }
    
    
    
    //  Primary_AddToCart_Btn_Method
    public void Primary_AddToCart_Btn_Method() throws InterruptedException
    {
    	for(int i=0;i<=2;i++)
    	{	
    		Primary_AddToCart_Btn.get(i).click();
    		Thread.sleep(2000);
    	}
    }

}
