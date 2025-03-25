import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Paths;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class J1_MULTIPLE_USER_BID {

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
    		  Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J1_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
    	      Page page = context.newPage();
    	      
    	      System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	      ChromeOptions options = new ChromeOptions();
    	      //options.addArguments("--headless");
    	          
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
    	          page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("AutomationM28")).click();
    	      });
              Thread.sleep(5000);
    	      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
    	      
    	      Thread.sleep(2000);
    	      Locator Confirmpopup = page2.locator("//*[@class='mb-0 btn-lg w-50 btn btn-primary' and text()='Confirm']");
    	      System.out.println("Confirm popup = " + Confirmpopup.isVisible());
    	      
              if (Confirmpopup.isVisible())
              {
            	  page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm")).click();
            	  System.out.println("Button Found");
              }
              else
              {
            	  System.out.println("Button Not found");
              }
    	      
    	      //page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm")).click();
    	      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
    	      Thread.sleep(4000);
    	      page2.locator("//*[@class='mb-0 btn btn-black']").click();
    	      Thread.sleep(2000);
    	          
              page2.getByLabel("Close").click();
              Thread.sleep(2000);
    	          
    	      bidinEuro = page2.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
    	      System.out.println("Bid in Euro = " + bidinEuro.substring(1, bidinEuro.length()));
    	        
    	      page.close();
	          context.close();
	          playwright.close();
    	     } 
    	      
    	      try (Playwright playwright = Playwright.create()) {
   		      Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
   	          BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J1_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
   	          Page page = context.newPage();
   	      
   	          System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
   	          ChromeOptions options = new ChromeOptions();
   	          //options.addArguments("--headless");
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
 	            page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("AutomationM28")).click();
 	          });
 	          
   	          Thread.sleep(5000);
   	          convertEURO2GBP = Double.parseDouble(bidinEuro.substring(1, bidinEuro.length())) * 0.8363;
	          System.out.println("EURO to GBP = " + String.format("%.02f", convertEURO2GBP));
	          
	          //convertGBP2PLN = convertEURO2GBP * 5.0086;
	          //System.out.println("GBP to EURO = " + String.format("%.02f", convertGBP2PLN));
	          
	          convertGBP2PLN = convertEURO2GBP * 4.993;
	          System.out.println("GBP to PLN = " + convertGBP2PLN);
	          BigDecimal amount1 = new BigDecimal(convertGBP2PLN);
	          BigDecimal  final1 = amount1.setScale(2,RoundingMode.DOWN);
	          System.out.println("GBP to PLN = " + final1);
	          
	          Verification = page2.locator("//*[@class='date d-block ms-0 mb-0 lossingText']").innerText();
	          System.out.println("Verification Amount = " + Verification.substring(2, Verification.length()).replace(",", ""));
	          
	          if((Double.parseDouble( Verification.substring(2, Verification.length()).replace(",", ""))) != (Double.parseDouble(final1.toString()))) {
	        	  Assert.fail("Bid Currency Not Match");
	          }
	          page.close();
	          context.close();
	          playwright.close();
     	 } 
    	   try (Playwright playwright = Playwright.create()) {
       		   Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
       	       BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J1_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
       	       Page page = context.newPage();
       	      
       	       System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
       	       ChromeOptions options = new ChromeOptions();
       	       options.addArguments("--headless");
       	          
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
 	           page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("AutomationM28")).click();
 	           });
       	       
               Thread.sleep(5000);
               page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
 	           page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
 	           Thread.sleep(4000);
 	              
 	           bidinPLN = page2.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
   	           System.out.println("Bid in PLN = " + bidinPLN.substring(2, bidinPLN.length()));
       	          
   	           page.close();
	           context.close();
	           playwright.close();
       	 } 
    	   try (Playwright playwright = Playwright.create()) {
    		   Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    	       BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J1_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
    	       Page page = context.newPage();
    	      
    	       System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	       ChromeOptions options = new ChromeOptions();
    	       //options.addArguments("--headless");
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
   	           page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("AutomationM28")).click();
   	           });
    	       
    	       Thread.sleep(5000);
    	       convertPLN2GBP = Double.parseDouble(bidinPLN.substring(2, bidinPLN.length())) * 0.2003;
 	           System.out.println("PLN to GBP = " + String.format("%.02f", convertPLN2GBP));
 	          
 	           convertGBP2EURO = (convertPLN2GBP * 1.1958);
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
 	           context.close();
 	           playwright.close();
      	 } 
    }
}
