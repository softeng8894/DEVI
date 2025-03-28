import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class Vendor_Manifest {

	@Test
    public void OpenBrowser() throws InterruptedException  {
    	
    	 try (Playwright playwright = Playwright.create()) {
    		  Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    	      BrowserContext context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("Vendor_Manifest/")).setRecordVideoSize(1280,720));
    	      Page page = context.newPage();
    	      
    	          System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	        
    	          page.navigate("https://concetto.jobalots.com/vendor/login");
    	          page.getByPlaceholder("Email").click();
    	          page.getByPlaceholder("Email").fill("dinesh@yopmail.com");
    	          page.getByPlaceholder("Password").click();
    	          page.getByPlaceholder("Password").fill("Test@123");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Listings ")).click();
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Manifest").setExact(true)).click();
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add Manifest")).click();
    	          page.getByPlaceholder("Manifest Title").click();
    	          page.getByPlaceholder("Manifest Title").fill("AutomationM104");
    	          page.getByPlaceholder("Manifest SKU").click();
    	          page.getByPlaceholder("Manifest SKU").fill("AutomationM104");
    	          page.getByPlaceholder("Manifest Quantity").click();
    	          page.getByPlaceholder("Manifest Quantity").fill("2");
    	          page.frameLocator("iframe[title=\"Editor\\, manifest_description\"]").locator("html").click();
    	          page.frameLocator("iframe[title=\"Editor\\, manifest_description\"]").getByLabel("Editor, manifest_description").fill("testing");
    	          page.locator("#select2-warehouse_id-container").click();
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("ITALY WAREHOUSE")).click();
    	          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Parcels")).click();
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Pallets")).click();
    	          page.locator("#select2-manifest_product_name_0-container").click();
    	          page.getByRole(AriaRole.SEARCHBOX).fill("cars");
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("CARS").setExact(true)).click();
    	          page.locator("#manifest_product_grade_0").selectOption("1");
    	          page.locator("#manifest_product_condition_0").selectOption("1");
    	          page.getByPlaceholder("Quantity", new Page.GetByPlaceholderOptions().setExact(true)).click();
    	          page.getByPlaceholder("Quantity", new Page.GetByPlaceholderOptions().setExact(true)).fill("2");
    	          page.getByPlaceholder("Weight (In KG)").click();
    	          page.getByPlaceholder("Weight (In KG)").fill("5000");
    	          page.getByPlaceholder("Weight (In KG)").press("Tab");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save").setExact(true)).click();
    	          
    	          page.close();
    	          context.close();
    	          playwright.close();
    	 } 
    }
}
