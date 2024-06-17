package PageObject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;



public class SortBy {
	
	WebDriver driver;
	
    public SortBy(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
	}
    
    
/* -----------------  Repository of Elements ------------------ */
    
     
    
    @FindBy(xpath="//select[@class='product_sort_container']") WebElement SortBy;
    
    @FindBy(xpath="//select[@class='product_sort_container']/child::option") List<WebElement> SortBy_Options;
    
    @FindBy(xpath="//div[@class='inventory_item_name ']") List<WebElement> Inventory_Items;
    @FindBy(xpath="//div[@class='inventory_item_price']") List<WebElement> Inventory_Prices;
 
    
    
/* --------------------------  Methods  --------------------------- */ 
    
    
    //  isSortBy_Option_Btn_Enabled
    public void isSortByBtn_Enabled()
    {
    	if(SortBy.isEnabled())
    	{
    		System.out.println("* SortBy_Option is Enabled \n");
    	}
    }
    
    
    //  ClickOn_SortBy
    public void ClickOn_SortBy() throws InterruptedException
    {
    	SortBy.click();
    	Thread.sleep(2000);
    }
    
    
    //  Check_SortBy_Options
    public void Check_SortBy_Options()
    {
    	System.out.println("Available SortBy Options are: ");
    	for(int i=0;i<SortBy_Options.size();i++)
    	{
    		System.out.println(SortBy_Options.get(i).getText());
    	}
    }
    
    
    
    
    //  Check_SortBy_Name_A_to_Z
    public void Check_SortBy_Name_A_to_Z() throws InterruptedException
    {
    	Select Name_A_to_Z=new Select(SortBy);
     	Name_A_to_Z.selectByIndex(0);
    	Thread.sleep(2000);
    	
    	System.out.println("* Inventory Items Name (A to Z): ");
    	Printing_Inventory_Item_Name_with_Price();
    	
    }
    
    
    //  Check_SortBy_Name_Z_to_A
    public void Check_SortBy_Name_Z_to_A() throws InterruptedException
    {
    	Select Name_Z_to_A=new Select(SortBy);
		Name_Z_to_A.selectByIndex(1);
    	Thread.sleep(2000);
    	
    	System.out.println("* Inventory Items Name (Z to A): ");
    	Printing_Inventory_Item_Name_with_Price();
    }
    
    
    //  Check_SortBy_Price_low_to_high
    public void Check_SortBy_Price_low_to_high() throws InterruptedException
    {
    	Select Price_low_to_high=new Select(SortBy);
    	Price_low_to_high.selectByIndex(2);
    	Thread.sleep(2000);
    	
    	System.out.println("* Inventory Items Price low to high: ");
    	Printing_Inventory_Item_Name_with_Price();
    }
    
    
    //Check_SortBy_Price_high_to_low
    public void Check_SortBy_Price_high_to_low() throws InterruptedException
    {
    	
    	Select Price_high_to_low=new Select(SortBy);
    	Price_high_to_low.selectByIndex(3);
    	Thread.sleep(2000);
    	
    	System.out.println("* Inventory Items Price high to low: ");
    	Printing_Inventory_Item_Name_with_Price();
    }
    
    
    
    //  Printing_Inventory_Item_Name_with_Price
    public void Printing_Inventory_Item_Name_with_Price()
    {
    	for(int i=0;i<Inventory_Items.size();i++)
    	{
    		System.out.println("Item Price:   "+Inventory_Prices.get(i).getText()+"   |   Item Name:   "+Inventory_Items.get(i).getText());
    	}
    	
    	System.out.println();
    }
    
    

}
