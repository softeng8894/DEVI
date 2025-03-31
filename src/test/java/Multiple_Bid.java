import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Multiple_Bid {

	public String bidinEuro;
	public String bidinPLN;
	public double convertEURO2GBP;
	public double convertGBP2PLN;
	public double convertPLN2GBP;
	public double convertGBP2EURO;
	public String Verification;
	public String Verification1;
	
	@Test
    public void OpenBrowser() throws InterruptedException  {
    	
    	      try (Playwright playwright = Playwright.create()) {
    		  
    	      Common_Browser cb = new Common_Browser();
    	      Page page = cb.Great();
    	          
    	      page.navigate("https://concetto-web.jobalots.com/en/login?currency=eur");
    	      page.getByPlaceholder("Email or mobile number").click();
    	      page.getByPlaceholder("Email or mobile number").fill("pd@yopmail.com");
    	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
    	      page.getByPlaceholder("Enter Password").click();
    	      page.getByPlaceholder("Enter Password").fill("Test@123");
    	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
    	      
    	      Page page1 = page.waitForPopup(() -> {
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View All")).nth(1).click();
    	      });
    	      Page page2 = page1.waitForPopup(() -> {
    	    	  Vendor_Manifest option1 = new Vendor_Manifest();
    	          page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(option1.optionName)).click();
    	      });
              Thread.sleep(5000);
    	      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
    	      
    	      Thread.sleep(2000);
    	      Locator Confirmpopup = page2.locator("//*[@class='mb-0 btn-lg w-50 btn btn-primary' and text()='Confirm']");
    	      System.out.println("Confirm popup = " + Confirmpopup.isVisible());
    	      
              if (Confirmpopup.isVisible())
              {
            	  page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm")).click();
              }

    	      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
    	      Thread.sleep(4000);
    	      page2.locator("//*[@class='mb-0 btn btn-black']").click();
    	      Thread.sleep(2000);
    	          
              page2.getByLabel("Close").click();
              Thread.sleep(2000);
    	          
    	      bidinEuro = page2.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
    	      System.out.println("Bid in Euro = " + bidinEuro.substring(1, bidinEuro.length()));
    	        
    	      page.close();
	          page.context().close();
	          playwright.close();
    	     } 
    	      
    	      try (Playwright playwright = Playwright.create()) {
   		      
    	      Common_Browser cb = new Common_Browser();
    	      Page page = cb.Great();
   	          
   	          page.navigate("https://concetto-web.jobalots.com/en/login?currency=eur");
   	          page.getByPlaceholder("Email or mobile number").click();
   	          page.getByPlaceholder("Email or mobile number").fill("gp@yopmail.com");
   	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
   	          page.getByPlaceholder("Enter Password").click();
   	          page.getByPlaceholder("Enter Password").fill("Test@123");
   	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
   	          
   	          Page page1 = page.waitForPopup(() -> {
 	            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View All")).nth(1).click();
 	          });
 	          Page page2 = page1.waitForPopup(() -> {
 	        	Vendor_Manifest option1 = new Vendor_Manifest();
 	            page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(option1.optionName)).click();
 	          });
 	          
   	          Thread.sleep(5000);
   	          convertEURO2GBP = Double.parseDouble(bidinEuro.substring(1, bidinEuro.length())) * 0.83616092;
	          System.out.println("EURO to GBP = " + String.format("%.02f", convertEURO2GBP));
	          
	          //convertGBP2PLN = convertEURO2GBP * 5.0086;
	          //System.out.println("GBP to EURO = " + String.format("%.02f", convertGBP2PLN));
	          
	          convertGBP2PLN = convertEURO2GBP * 4.99842738;
	          System.out.println("GBP to PLN = " + convertGBP2PLN);
	          BigDecimal amount1 = new BigDecimal(convertGBP2PLN);
	          BigDecimal  final1 = amount1.setScale(2,RoundingMode.DOWN);
	          System.out.println("GBP to PLN = " + final1);
	          
    	      Locator Notag = page2.locator("//*[@class='date d-block ms-0 mb-0 ']");
    	      System.out.println("Tag Status= " + Notag.isVisible());
    	      
              if (Notag.isVisible())
              {
            	  Verification = page2.locator("//*[@class='date d-block ms-0 mb-0 ']").innerText();
    	          System.out.println("Verification Amount = " + Verification.substring(2, Verification.length()).replace(",", ""));
              }
              else
              {
            	  Verification = page2.locator("//*[@class='date d-block ms-0 mb-0 lossingText']").innerText();
    	          System.out.println("Verification Amount = " + Verification.substring(2, Verification.length()).replace(",", ""));
              }
	         
	          if((Double.parseDouble( Verification.substring(2, Verification.length()).replace(",", ""))) != (Double.parseDouble(final1.toString()))) {
	        	  Assert.fail("Bid Currency Not Match");
	          }
	          page.close();
	          page.context().close();
	          playwright.close();
     	 } 
    	   try (Playwright playwright = Playwright.create()) {
    		   
    		   Common_Browser cb = new Common_Browser();
 		       Page page = cb.Great();
       	          
       	       page.navigate("https://concetto-web.jobalots.com/en/login?currency=eur");
       	       page.getByPlaceholder("Email or mobile number").click();
       	       page.getByPlaceholder("Email or mobile number").fill("gp@yopmail.com");
               page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
     	       page.getByPlaceholder("Enter Password").click();
       	       page.getByPlaceholder("Enter Password").fill("Test@123");
       	       page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
       	      
       	       Page page1 = page.waitForPopup(() -> {
 	             page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View All")).nth(1).click();
 	           });
 	             Page page2 = page1.waitForPopup(() -> {
 	           Vendor_Manifest option1 = new Vendor_Manifest();
 	           page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(option1.optionName)).click();
 	           });
       	       
               Thread.sleep(5000);
               page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
 	           page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
 	           Thread.sleep(4000);
 	              
 	           bidinPLN = page2.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
   	           System.out.println("Bid in PLN = " + bidinPLN.substring(2, bidinPLN.length()));
       	          
   	           page.close();
	           page.context().close();
	           playwright.close();
       	 } 
    	   try (Playwright playwright = Playwright.create()) {
    		   
    		   Common_Browser cb = new Common_Browser();
 		       Page page = cb.Great();
    	       
    	       page.navigate("https://concetto-web.jobalots.com/en/login?currency=eur");
    	       page.getByPlaceholder("Email or mobile number").click();
    	       page.getByPlaceholder("Email or mobile number").fill("pd@yopmail.com");
    	       page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
    	       page.getByPlaceholder("Enter Password").click();
    	       page.getByPlaceholder("Enter Password").fill("Test@123");
    	       page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
    	      
    	       Page page1 = page.waitForPopup(() -> {
   	             page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View All")).nth(1).click();
   	           });
   	             Page page2 = page1.waitForPopup(() -> {
   	           Vendor_Manifest option1 = new Vendor_Manifest();
   	           page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(option1.optionName)).click();
   	           });
    	       
    	       Thread.sleep(5000);
    	       convertPLN2GBP = Double.parseDouble(bidinPLN.substring(2, bidinPLN.length())) * 0.2000631;
 	           System.out.println("PLN to GBP = " + String.format("%.02f", convertPLN2GBP));
 	          
 	           convertGBP2EURO = (convertPLN2GBP * 1.19594314);
 	           System.out.println("GBP to EURO = " + convertGBP2EURO);
 	           BigDecimal amount2 = new BigDecimal(convertGBP2EURO);
 	           BigDecimal  final2 = amount2.setScale(2,RoundingMode.DOWN);
	           System.out.println("GBP to EURO = " + final2);
 	          
	           Verification1 = page2.locator("//*[@class='date d-block ms-0 mb-0 lossingText']").innerText();
	           System.out.println("Verification Amount = " + Verification1.substring(1, Verification1.length()).replace(",", ""));
	          
	           if((Double.parseDouble( Verification1.substring(1, Verification1.length()).replace(",", ""))) != (Double.parseDouble(final2.toString()))) {
	        	  Assert.fail("Bid Currency Not Match");
	           }
	           page.close();
 	           page.context().close();
 	           playwright.close();
      	 } 
    }
}
