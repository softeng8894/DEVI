import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;


import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Vendor_Manifest {

	@Test
    public void OpenBrowser() throws InterruptedException  {
    	
    	 try (Playwright playwright = Playwright.create()) {
    		  Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("Vendor_Manifest/")).setRecordVideoSize(1280,720));
    	      //BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,953));
    	      Page page = context.newPage();
    	      
    	          System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	          ChromeOptions options = new ChromeOptions();
    	          //options.addArguments("--headless");
    	        
    	          page.navigate("https://concetto.jobalots.com/vendor/login");
    	          page.getByPlaceholder("Email").click();
    	          page.getByPlaceholder("Email").fill("dinesh@yopmail.com");
    	          page.getByPlaceholder("Password").click();
    	          page.getByPlaceholder("Password").fill("Test@123");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    	          Thread.sleep(4000);
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Listings ")).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Manifest").setExact(true)).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add Manifest")).click();
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Manifest Title").click();
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Manifest Title").fill("AutomationM38");
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Manifest SKU").click();
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Manifest SKU").fill("AutomationM38");
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Manifest Quantity").click();
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Manifest Quantity").fill("2");
    	          Thread.sleep(1000);
    	          page.frameLocator("iframe[title=\"Editor\\, manifest_description\"]").locator("html").click();
    	          Thread.sleep(1000);
    	          page.frameLocator("iframe[title=\"Editor\\, manifest_description\"]").getByLabel("Editor, manifest_description").fill("testing");
    	          Thread.sleep(1000);
    	          page.locator("#select2-warehouse_id-container").click();
    	          Thread.sleep(1000);
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("ITALY WAREHOUSE")).click();
    	          Thread.sleep(1000);
    	          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Parcels")).click();
    	          Thread.sleep(1000);
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Pallets")).click();
    	          Thread.sleep(1000);
    	          page.locator("#select2-manifest_product_name_0-container").click();
    	          Thread.sleep(1000);
    	          page.getByRole(AriaRole.SEARCHBOX).fill("cars");
    	          Thread.sleep(1000);
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("CARS").setExact(true)).click();
    	          Thread.sleep(1000);
    	          page.locator("#manifest_product_grade_0").selectOption("1");
    	          Thread.sleep(1000);
    	          page.locator("#manifest_product_condition_0").selectOption("1");
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Quantity", new Page.GetByPlaceholderOptions().setExact(true)).click();
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Quantity", new Page.GetByPlaceholderOptions().setExact(true)).fill("2");
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Weight (In KG)").click();
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Weight (In KG)").fill("5000");
    	          Thread.sleep(1000);
    	          page.getByPlaceholder("Weight (In KG)").press("Tab");
    	          Thread.sleep(1000);
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save").setExact(true)).click();
    	          Thread.sleep(1000);
    	          
    	          page.close();
    	          context.close();
    	          playwright.close();
    	 } 
    }
}
