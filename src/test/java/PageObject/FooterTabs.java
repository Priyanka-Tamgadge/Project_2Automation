package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterTabs {
	
	    WebDriver driver;
		
	    public FooterTabs(WebDriver idriver)
		{
			driver=idriver;
			PageFactory.initElements(driver, this);  //initElements is a method used to initialize web elements.
		}
	    
	    
/* -----------------  Repository of Elements ------------------ */
	    
	     
	    @FindBy(xpath="//li[@class='social_twitter']") WebElement Twitter_Link;
	    @FindBy(xpath="//li[@class='social_facebook']") WebElement Facebook_Link;
	    @FindBy(xpath="//li[@class='social_linkedin']") WebElement Linkedin_Link;
	    
	    @FindBy(xpath="//div[@class='footer_copy']") WebElement Footer_Copy;
	    
	    
/* --------------------------  Methods  --------------------------- */ 
	    
	    
	    
	    //  isTwitter_Link_Enabled
	    public void isTwitter_Link_Enabled()
	    {
	    	if(Twitter_Link.isEnabled())
	    	{
	    		System.out.println("* Twitter_Link is Enabled \n");
	    	}
	    }
	    
	    
	    //  isFacebook_Link_Enabled
	    public void isFacebook_Link_Enabled()
	    {
	    	if(Facebook_Link.isEnabled())
	    	{
	    		System.out.println("* Facebook_Link is Enabled \n");
	    	}
	    }
	    
	    
	    //  isLinkedin_Link_Enabled
	    public void isLinkedin_Link_Enabled()
	    {
	    	if(Linkedin_Link.isEnabled())
	    	{
	    		System.out.println("* Linkedin_Link is Enabled \n");
	    	}
	    }
	    
	    
	    //  clickOn_Twitter_Link
	    public void clickOn_Twitter_Link() throws InterruptedException
	    {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    Thread.sleep(2000);
	    	
	    	Twitter_Link.click();
	    	Thread.sleep(10000);
	    }
	    
	    
	    //  clickOn_Facebook_Link
	    public void clickOn_Facebook_Link() throws InterruptedException
	    {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    Thread.sleep(2000);
	    	
	    	Facebook_Link.click();
	    	Thread.sleep(5000);
	    }
	    
	    
	    //  clickOn_Linkedin_Link
	    public void clickOn_Linkedin_Link() throws InterruptedException
	    {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    Thread.sleep(2000);
	    	
	    	Linkedin_Link.click();
	    	Thread.sleep(5000);
	    }
	   
	    
	    //   isFooter_Item_Dispalyed
	    public void isFooter_Copy_Dispalyed()
	    {
	    	System.out.println();
	    	if(Footer_Copy.isDisplayed())
	    	{
	    		System.out.println("* Footer_Copy: "+Footer_Copy.getText()+"\n");
	    	}
	    } 

}
