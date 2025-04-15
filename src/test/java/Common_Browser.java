import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Common_Browser {
	
	public Playwright playwright;
	public Browser browser;
	public BrowserContext context;
	public Page page;
	
	    public Page Great() {	
	        Playwright playwright = Playwright.create();
	        Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
  	        //BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("RECORD/")).setRecordVideoSize(1280,720));
	        BrowserContext context = browser.newContext(new NewContextOptions().setViewportSize(1900,780));
  	        Page page = context.newPage();
  	        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
  	        return page;
		}
}
