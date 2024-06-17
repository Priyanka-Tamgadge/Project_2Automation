package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	
    WebDriver driver;
	
    public Checkout(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------  Repository of Elements ------------------ */
    
    
    @FindBy(id="checkout") WebElement Checkout_Btn;
    
    @FindBy(id="first-name") WebElement First_Name;
    @FindBy(id="last-name") WebElement Last_Name;
    @FindBy(id="postal-code") WebElement Postal_Code;
    @FindBy(id="continue") WebElement Continue_Btn;
    
    @FindBy(xpath="//div[@class='error-message-container error']/child::h3") WebElement Error_Message;
    @FindBy(xpath="//button[@class='error-button']") WebElement Error_Btn;
    
    @FindBy(xpath="//div[@class='inventory_item_name']") List<WebElement> Cart_Items_List;
    @FindBy(xpath="//div[@class='inventory_item_price']") List<WebElement> Price_List;
    @FindBy(xpath="//div[@class='cart_quantity']") List<WebElement> Quantity_List;
    
  
    @FindBy(id="cancel") WebElement Cancel_Btn;
    @FindBy(id="finish") WebElement Finish_Btn;
    
    @FindBy(xpath="//div[@class='summary_info_label'][1]") WebElement Payment_Info;
    @FindBy(xpath="//div[@class='summary_value_label'][1]") WebElement Payment_Info_Value;
    
    @FindBy(xpath="//div[@class='summary_info_label'][2]") WebElement Shipping_Info;
    @FindBy(xpath="//div[@class='summary_value_label'][2]") WebElement Shipping_Info_Value;
    
    @FindBy(xpath="//div[@class='summary_info_label'][3]") WebElement Price_Total;
    @FindBy(xpath="//div[@class='summary_subtotal_label']") WebElement Item_Total;
    @FindBy(xpath="//div[@class='summary_tax_label']") WebElement Tax;
    
    @FindBy(xpath="//div[@class='summary_total_label']") WebElement Total;
    
    @FindBy(xpath="//h2[@class='complete-header']") WebElement Success_Msg;
    
    @FindBy(id="back-to-products") WebElement BackHome_Btn;
    
    
/* --------------------------  Methods  --------------------------- */ 
    
    
    
    
       public void clickOn_Checkout_Btn() throws InterruptedException
      {
    	   JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
           Thread.sleep(2000);

    	   
    	   Checkout_Btn.click();
    	   Thread.sleep(2000);
      }
      
      
/* -------------    Checkout: Your Information     ------------- */ 
       
      public void enter_FirstName(String fn) throws InterruptedException
      {
    	  First_Name.clear();
    	  First_Name.sendKeys(fn);
    	  Thread.sleep(2000);
      }
      
      public void enter_LastName(String ln) throws InterruptedException
      {
    	  Last_Name.clear();
    	  Last_Name.sendKeys(ln);
    	  Thread.sleep(2000);
      }
      
      public void enter_PostalCode(String pc) throws InterruptedException
      {
    	  Postal_Code.clear();
    	  Postal_Code.sendKeys(pc);
    	  Thread.sleep(2000);
      }
      
      
      public void clickOn_Continue_Btn() throws InterruptedException
      {
    	  
    	  Continue_Btn.click();
    	  Thread.sleep(2000);
      }
      
      public void Error_Message_For_blank_Details() throws InterruptedException
      {
    	  Error_Message.getText();
    	  Thread.sleep(2000);
      }
      
      
      public void enter_Your_Information(String fn,String ln,String pc) throws InterruptedException
      {
    	     enter_FirstName(fn);
    	     Thread.sleep(1000);
	    	 
    	     enter_LastName(ln);
	    	 Thread.sleep(1000);
	    	 
	    	 enter_PostalCode(pc);
	    	 Thread.sleep(1000);
	    	 
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;
		     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		     Thread.sleep(2000);
	    	 
	    	 clickOn_Continue_Btn();
	    	 Thread.sleep(2000);
      }
      
      
      public void Clear_Details() throws InterruptedException
      {
    	  First_Name.clear();
    	  Thread.sleep(1000);
	      Last_Name.clear();
	      Thread.sleep(1000);
	      Postal_Code.clear();
	      Thread.sleep(1000);
	      Thread.sleep(2000);
      }
      
      
      
      
/* -------------    Checkout: Overview     ------------- */      
      
       //  Access_Checkout_Items
	    public void Access_Checkout_Items() throws InterruptedException
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
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        Thread.sleep(2000);

			
	    }
	    
	    
	    public void Access_Payment_Infirmation() throws InterruptedException
	    {
	    	System.out.println();
	    	System.out.println("* "+Payment_Info.getText());
	    	System.out.println(Payment_Info_Value.getText());
	    	System.out.println();
	    }
	    
	    public void Access_Shipping_Infirmation()
	    {
	    	System.out.println("* "+Shipping_Info.getText());
	    	System.out.println(Shipping_Info_Value.getText());
	    	System.out.println();
	    }
	    
	    public void Access_Price_Infirmation()
	    {
	    	System.out.println("* "+Price_Total.getText());
	    	System.out.println(Tax.getText());
	    	System.out.println();
	    }
	    
	    public void Access_Total_Infirmation()
	    {
	    	System.out.println("* "+Total.getText());
	    	System.out.println();
	    }
	    
	    
	    public void clickOn_Finish_Btn() throws InterruptedException
	    {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        Thread.sleep(2000);

	    	
	    	Finish_Btn.click();
	    	Thread.sleep(2000);
	    }
	    
	    
/* -------------    Checkout: Complete!     ------------- */
	    
	    
	    public void Access_Success_Msg()
	    {
	    	System.out.println(Success_Msg.getText());
	    	System.out.println();
	    }
	    
	    
	    public void isBackHome_Btn_Enabled() throws InterruptedException
	    {
	    	if(BackHome_Btn.isEnabled())
	        	{
	        		System.out.println("* BackHome_Btn is Enabled: "+BackHome_Btn.getText());
	        		System.out.println();
	        	}
	    	Thread.sleep(2000);
	    }
	    
	    
	    
/* -------------    Error_Message_Blank_Details     ------------- */
	    
	    
	     //  Error_Message_Blank_Details
	     public void Error_Message_Blank_Details(String fn,String ln,String pc) throws InterruptedException
	     {
	    	 Clear_Details();
	    	 
	    	 enter_FirstName(fn);
	    	 enter_LastName(ln);
	    	 enter_PostalCode(pc);
	    	 
	    	 clickOn_Continue_Btn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(First_Name.getText()=="" || Last_Name.getText()==""  || Postal_Code.getText()=="")
	    	 {
	    		 System.out.println(Error_Message.getText());
	    		 Thread.sleep(2000);
	    		 System.out.println();
	    		 Error_Btn.click();
	    		 Thread.sleep(2000);
	    		 Cancel_Btn.click();
	    		 Thread.sleep(1000);
	    		 Checkout_Btn.click();
	    		 Thread.sleep(1000);
	    	 }
	     } 
	    
	    
	    
	    //  Error_Message_BlankFirst_Name
	     public void Error_Message_Blank_First_Name(String fn,String ln,String pc) throws InterruptedException
	     {
	    	 Clear_Details();
	    	 
	    	 enter_FirstName(fn);
	    	 enter_LastName(ln);
	    	 enter_PostalCode(pc);
	    	 
	    	 clickOn_Continue_Btn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(First_Name.getText()=="" || Last_Name.getText()==""  || Postal_Code.getText()=="")
	    	 {
	    		 System.out.println(Error_Message.getText());
	    		 Thread.sleep(2000);
	    		 System.out.println();
	    		 Error_Btn.click();
	    		 Thread.sleep(2000);
	    		 Cancel_Btn.click();
	    		 Thread.sleep(1000);
	    		 Checkout_Btn.click();
	    		 Thread.sleep(1000);
	    	 }
	     }
	     
	     
	     //  Error_Message_BlankFirst_Name
	     public void Error_Message_Blank_Last_Name(String fn,String ln,String pc) throws InterruptedException
	     {
	    	 Clear_Details();
	    	 
	    	 enter_FirstName(fn);
	    	 enter_LastName(ln);
	    	 enter_PostalCode(pc);
	    	 
	    	 clickOn_Continue_Btn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(First_Name.getText()=="" || Last_Name.getText()==""  || Postal_Code.getText()=="")
	    	 {
	    		 System.out.println(Error_Message.getText());
	    		 Thread.sleep(2000);
	    		 System.out.println();
	    		 Error_Btn.click();
	    		 Thread.sleep(2000);
	    		 Cancel_Btn.click();
	    		 Thread.sleep(1000);
	    		 Checkout_Btn.click();
	    		 Thread.sleep(1000);
	    	 }
	     }
	     
	     
	     //  Error_Message_Blank_Postal_Code
	     public void Error_Message_Blank_Postal_Code(String fn,String ln,String pc) throws InterruptedException
	     {
	    	 Clear_Details();
	    	 
	    	 enter_FirstName(fn);
	    	 enter_LastName(ln);
	    	 enter_PostalCode(pc);
	    	 
	    	 clickOn_Continue_Btn();
	    	 Thread.sleep(2000);
	    	 
	    	 if(First_Name.getText()=="" || Last_Name.getText()==""  || Postal_Code.getText()=="")
	    	 {
	    		 System.out.println(Error_Message.getText());
	    		 Thread.sleep(2000);
	    		 System.out.println();
	    		 Error_Btn.click();
	    		 Thread.sleep(2000);
	    		 Cancel_Btn.click();
	    		 Thread.sleep(1000);
	    		 Checkout_Btn.click();
	    		 Thread.sleep(1000);
	    	 }
	     }
     	    

}
