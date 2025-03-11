import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class J1_LOGIN_AND_BID {

	@Test
    public void OpenBrowser() throws InterruptedException  {
    	
    	 try (Playwright playwright = Playwright.create()) {
    	      //Browser browser = playwright.firefox().launch();
    		  Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("J1_LOGIN_AND_BID/")));
    	      //BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,953));
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
    	            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Automation1")).click();
    	          });
    	          Thread.sleep(5000);
    	          page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
    	          page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
    	          Thread.sleep(4000);
    	          page1.locator("//*[@class='mb-0 btn btn-black']").click();
    	          Thread.sleep(2000);
    	          page1.getByLabel("Close").click();
    	          Thread.sleep(2000);
    	          page.close();
    	          playwright.close();
    	 } 
    }
}
