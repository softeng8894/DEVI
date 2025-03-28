import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class Vendor_Auction {

	@Test
    public void OpenBrowser() throws InterruptedException  {
    	
    	 try (Playwright playwright = Playwright.create()) {
    	      //Browser browser = playwright.firefox().launch();
    		  Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("Vendor_Auction/")).setRecordVideoSize(1280,720));
    	      //BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,953));
    	      Page page = context.newPage();
    	      
    	          System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	          //ChromeOptions options = new ChromeOptions();
    	          //options.addArguments("--headless");
    	        
    	          page.navigate("https://concetto.jobalots.com/vendor/login");
    	          page.getByPlaceholder("Email").click();
    	          page.getByPlaceholder("Email").fill("dinesh@yopmail.com");
    	          page.getByPlaceholder("Password").click();
    	          page.getByPlaceholder("Password").fill("Test@123");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Listings ")).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Auction").setExact(true)).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add Auction")).click();
    	          Thread.sleep(2000);
    	          page.getByText("Select Manifest").click();
    	          page.getByRole(AriaRole.SEARCHBOX).fill("AutomationM104");
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("AutomationM104")).click();
    	          page.getByPlaceholder("Reserve Price").click();
    	          page.getByPlaceholder("Reserve Price").fill("10");
    	          page.getByPlaceholder("Start Bid Price").click();
    	          page.getByPlaceholder("Start Bid Price").fill("10");
    	          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Select Location")).click();
    	          page.getByRole(AriaRole.SEARCHBOX).fill("ita");
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Italy")).click();
    	          page.getByPlaceholder("End At").click();
    	          page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("28")).nth(1).click();
    	          page.locator(".hourselect").first().selectOption("10");
    	          page.locator(".minuteselect").first().selectOption("45");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply")).click();
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
    	          
    	          page.close();
    	          context.close();
    	          playwright.close();
    	 } 
    }
}
