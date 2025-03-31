import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class Checkout {

	public String FinalAmount;
	public String NetPrice;
	public String NetPrice1;
	public String NetPrice2;
	public String Verification;
	
	@Test
    public void OpenBrowser() throws InterruptedException  {
    	
    	 try (Playwright playwright = Playwright.create()) {
    		  
    		  Common_Browser cb = new Common_Browser();
		      Page page = cb.Great();
    	        
              page.navigate("https://concetto-web.jobalots.com/en/login?currency=pln");
              page.getByPlaceholder("Email or mobile number").click();
       	      page.getByPlaceholder("Email or mobile number").fill("gp@yopmail.com");
              page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        	  page.getByPlaceholder("Enter Password").click();
              page.getByPlaceholder("Enter Password").fill("Test@123");
       	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
       	      Thread.sleep(2000);   
       	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("1").setExact(true)).click();
        	  Thread.sleep(3000);
        	  FinalAmount = page.locator("(//*[@class='fw-600'])[1]").innerText();
        	  System.out.println("Amount in My Cart page = " + FinalAmount.substring(2, FinalAmount.length()));
        	  Thread.sleep(3000);
              page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Checkout now!")).click();
              Thread.sleep(3000);
              NetPrice = page.locator("(//*[@class='fw-bold'])[1]").innerText();
        	  System.out.println("Amount in Order page = " + NetPrice.substring(2, NetPrice.length()));
        	  Thread.sleep(3000);
        	  if(Double.parseDouble(FinalAmount.substring(2, FinalAmount.length()))  == Double.parseDouble(NetPrice.substring(2, NetPrice.length())))
        	  {
            	  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place order now!")).click();
                  Thread.sleep(3000);
            	  NetPrice1 = page.locator("(//*[@class='fw-bold'])[1]").innerText();
            	  System.out.println("Amount in Order page = " + NetPrice.substring(2, NetPrice.length()));
            	  System.out.println("Amount in Address page = " + NetPrice1.substring(2, NetPrice1.length()));
            	  
            	  if(Double.parseDouble(NetPrice.substring(2, NetPrice.length()))  == Double.parseDouble(NetPrice1.substring(2, NetPrice1.length())))
            	  {
            		  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue to payment now!")).click();
            		  Thread.sleep(3000);
            		  NetPrice2 = page.locator("(//*[@class='fw-bold'])[1]").innerText();
                	  System.out.println("Amount in Card page = " + NetPrice2.substring(2, NetPrice.length()));
                	  
                	  if(Double.parseDouble(NetPrice1.substring(2, NetPrice1.length()))  == Double.parseDouble(NetPrice2.substring(2, NetPrice2.length())))
                	  {
            		     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay now")).click();
            	         Thread.sleep(10000);
                         page.frameLocator("iframe[name=\"cko-3ds2-iframe\"]").getByPlaceholder("Hint: Checkout1!").click();
                         page.frameLocator("iframe[name=\"cko-3ds2-iframe\"]").getByPlaceholder("Hint: Checkout1!").fill("Checkout1!");
                         Thread.sleep(3000);
                         page.frameLocator("iframe[name=\"cko-3ds2-iframe\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Continue")).click();
                         Thread.sleep(20000);
                         
                         page.locator("li").filter(new Locator.FilterOptions().setHasText("Welcome geetaben patelMy")).locator("path").click();
                         page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign Out")).click();
                         page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
                         Thread.sleep(2000);
                         
                         Locator Loginbutton = page.locator("//*[@class='mb-lg-0 w-100 btn btn-primary']");
               	      
                         if (Loginbutton.isVisible())
                         {
                       	   System.out.print("Checkout flow is working fine");
                         }
                         else 
                         {
                        	 System.out.print("Checkout flow is Not working fine");
					 	 }
                         page.close();
           	             page.context().close();
           	             playwright.close();
                	  }
            	  }
        	  }   
    	 } 
    }
}
