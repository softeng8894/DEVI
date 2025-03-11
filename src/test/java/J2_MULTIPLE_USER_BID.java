import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;

import org.bouncycastle.pkix.SubjectPublicKeyInfoChecker;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class J2_MULTIPLE_USER_BID {

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
    	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J2_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
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
              page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Automatic21")).click();
    	       });
              Thread.sleep(5000);
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
    	      Thread.sleep(4000);
    	      page1.locator("//*[@class='mb-0 btn btn-black']").click();
    	      Thread.sleep(2000);
    	          
              page1.getByLabel("Close").click();
              Thread.sleep(2000);
    	          
    	      bidinEuro = page1.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
    	      System.out.println("Bid in Euro = " + bidinEuro.substring(1, bidinEuro.length()));
    	        
              page.close();
    	      playwright.close();
    	     } 
    	      try (Playwright playwright = Playwright.create()) {
   		      Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
   	          BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J2_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
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
   	            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Automatic21")).click();
   	          });
   	          Thread.sleep(5000);
   	          convertEURO2GBP = Double.parseDouble(bidinEuro.substring(1, bidinEuro.length())) * 0.84;
	          System.out.println("EURO to GBP = " + String.format("%.02f", convertEURO2GBP));
	          
	          convertGBP2PLN = convertEURO2GBP * 4.9681;
	          System.out.println("GBP to PLN = " + String.format("%.02f", convertGBP2PLN));
	          
	          Verification = page1.locator("//*[@class='date d-block ms-0 mb-0 lossingText']").innerText();
	          System.out.println("Verification Amount = " + Verification.substring(2, Verification.length()).replace(",", ""));
	          
	          if((Double.parseDouble( Verification.substring(2, Verification.length()).replace(",", ""))) != (Double.parseDouble(String.format("%.02f", convertGBP2PLN)))) {
	        	  Assert.fail("Bid Currency Not Match");
	          }
	          page.close();
   	          playwright.close();
     	 } 
    	   try (Playwright playwright = Playwright.create()) {
       		   Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
       	       BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J2_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
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
       	       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Automatic21")).click();
               });
               Thread.sleep(5000);
               page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
 	           page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
 	           Thread.sleep(4000);
 	              
 	           bidinPLN = page1.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
   	           System.out.println("Bid in PLN = " + bidinPLN.substring(2, bidinPLN.length()));
       	          
    	       page.close();
       	       playwright.close();
       	 } 
    	   try (Playwright playwright = Playwright.create()) {
    		   Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    	       BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J2_MULTIPLE_USER_BID/")).setRecordVideoSize(1280,720));
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
    	         page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Automatic21")).click();
               });
    	      Thread.sleep(5000);
    	      convertPLN2GBP = Double.parseDouble(bidinPLN.substring(2, bidinPLN.length())) * 0.2013;
 	          System.out.println("PLN to GBP = " + String.format("%.02f", convertPLN2GBP));
 	          
 	          convertGBP2EURO = convertPLN2GBP * 1.1905;
	          System.out.println("GBP to EURO = " + String.format("%.02f", convertGBP2EURO));
 	          
	          Verification1 = page1.locator("//*[@class='date d-block ms-0 mb-0 lossingText']").innerText();
	          System.out.println("Verification Amount = " + Verification1.substring(1, Verification1.length()).replace(",", ""));
	          
	          if((Double.parseDouble( Verification1.substring(1, Verification1.length()).replace(",", ""))) != (Double.parseDouble(String.format("%.02f", convertGBP2EURO)))) {
	        	  Assert.fail("Bid Currency Not Match");
	          }
 	          page.close();
    	      playwright.close();
      	 } 
    }
}
