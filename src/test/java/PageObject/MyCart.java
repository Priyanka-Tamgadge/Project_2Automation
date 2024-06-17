package PageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCart {
	
	 WebDriver driver;
		
	    public MyCart(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}
	    
	    
/* -----------------  Repository of Elements ------------------ */
	    
	     
	    @FindBy(xpath="//a[@class='shopping_cart_link']") WebElement MyCart;
	    @FindBy(xpath="//div[@class='cart_quantity_label']") WebElement Quantity_Label;
	    @FindBy(xpath="//div[@class='cart_desc_label']") WebElement Description_Label;
	    @FindBy(id="continue-shopping") WebElement Continue_shopping_Btn;
	    @FindBy(id="checkout") WebElement Checkout_Btn;
	    
	    @FindBy(id="react-burger-menu-btn") WebElement Open_Menu_Btn;
	    @FindBy(xpath="//nav[@class='bm-item-list']/child::a") List<WebElement> Options_Inside_Menu;

	    
	    @FindBy(xpath="//div[@class='inventory_item_name']") List<WebElement> Cart_Items_List;
	    @FindBy(xpath="//div[@class='inventory_item_price']") List<WebElement> Price_List;
	    @FindBy(xpath="//div[@class='cart_quantity']") List<WebElement> Quantity_List;
	    
	    
	    
	    
/* --------------------------  Methods  --------------------------- */ 
	    
	    
	    //  isMy_Cart_Enabled
	    public void isMy_Cart_Enabled()
	    {
	    	if(MyCart.isEnabled())
	    	{
	    		System.out.println("* My_Cart is Enabled \n");
	    	}
	    }
	    
	    
	    //  clickOn_MyCart
	    public void clickOn_MyCart() throws InterruptedException
	    {
	    	MyCart.click();
	    	Thread.sleep(3000);
	    }
	    
	   
	    //   isQuantity_Label_Dispalyed
	    public void isQuantity_Label_Dispalyed()
	    {
	    	if(Quantity_Label.isDisplayed())
	    	{
	    		System.out.println("* Quantity_Label is Present:   "+Quantity_Label.getText()+"\n");
	    	}
	    }
	    
	   
	    //  isDescription_Label_Dispalyed
	    public void isDescription_Label_Dispalyed()
	    {
	    	if(Description_Label.isDisplayed())
	    	{
	    		System.out.println("* Description_Label is Present:   "+Description_Label.getText()+"\n");
	    	}
	    }
	    
	    
	//  isContinue_shopping_Btn_Enabled
	    public void isContinue_shopping_Btn_Enabled()
	    {
	    	if(Continue_shopping_Btn.isEnabled())
	    	{
	    		System.out.println("* Continue_shopping_Btn is Enabled \n");
	    	}
	    }
	    
	    
	    //  isCheckout_Btn_Enabled
	    public void isCheckout_Btn_Enabled()
	    {
	    	if(Checkout_Btn.isEnabled())
	    	{
	    		System.out.println("* Checkout_Btn is Enabled \n");
	    	}
	    }
	    
	    
	    //  ClickOn_All_Items
	    public void ClickOn_All_Items() throws InterruptedException
	    {
	    	Open_Menu_Btn.click();
	    	Thread.sleep(2000);
	    	
	    	for(int i=0;i<Options_Inside_Menu.size();i++)
	    	{
	    		Actions act=new Actions(driver);
	   		    act.moveToElement(Options_Inside_Menu.get(i)).build().perform();
	   		    Thread.sleep(1000);
	   		    
	   		    String result_1="All Items";
	   		    String result_2=Options_Inside_Menu.get(i).getText();
	   		    
	   		    if(result_1.equals(result_2))
	   		    {
	   		    	Options_Inside_Menu.get(i).click();
	   		    }
	   		    
	    	}
	    	
	    	Thread.sleep(3000);
	    }
	    
	    
	    //  Access_MyCart_Items
	    public void Access_MyCart_Items() throws InterruptedException
	    {
	    	Actions act=new Actions(driver);
	    	
			System.out.println("\n* Items Inside Cart: \n");
			
			
			// Item Name
			for(int i=0;i<Cart_Items_List.size();i++)
	    	{
				System.out.println();
				act.moveToElement(Cart_Items_List.get(i)).build().perform();
				Thread.sleep(2000);
				
				String Cart_Item=Cart_Items_List.get(i).getText();
	    		System.out.println(Cart_Item);
	    		
	    		// Item Price
	    		for(int j=0;j<Price_List.size();j++)
	    		{
	    			if(i==j)
	    			{
	    				String Price=Price_List.get(j).getText();
	    	    		System.out.println("Price: "+Price);
	    			}
	    		}
	    		
	    		// Item Quantity
	    		for(int n=0;n<Quantity_List.size();n++)
	    		{
	    			if(i==n)
	    			{
	    				String Quantity=Quantity_List.get(n).getText();
	    	    		System.out.println("Quantity: "+Quantity);
	    			}
	    		}
	    	
	    	}
			
			act.sendKeys(Keys.PAGE_DOWN);
    		Thread.sleep(2000);
    		System.out.println();
			
	    }

	    
	    
	 

	    
	    

}
