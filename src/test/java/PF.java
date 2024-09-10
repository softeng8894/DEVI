import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class PF {

    @Test
    public void OpenBrowser()  {
    	
    	 try (Playwright playwright = Playwright.create()) {
    	      //Browser browser = playwright.firefox().launch();
    		 Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(true));
    	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
    	      Page page = context.newPage();
    	      
    	          System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	          ChromeOptions options = new ChromeOptions();
    	          options.addArguments("--headless");
    	      
    	    	  page.navigate("https://www.youtube.com/");
    	    	  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("History")).click();
    	          page.getByLabel("Clear all watch history").click();
    	          page.getByLabel("Clear watch history").click();
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home").setExact(true)).click();
    	          String xpathSelector = "(//*[@class='yt-spec-touch-feedback-shape__fill'])[4]";
    	          Locator element = page.locator(xpathSelector);
    	          System.out.println("King of automation and ci-cd");
    	          page.close();
    	          playwright.close();
    	 } 
    }
}
