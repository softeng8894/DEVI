import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class Vendor_Auction {

	@Test
    public void OpenBrowser() throws InterruptedException  {
    	
    	 try (Playwright playwright = Playwright.create()) {
    		
    		      Common_Browser cb = new Common_Browser();
		          Page page = cb.Great();
    	        
    	          page.navigate("https://concetto.jobalots.com/vendor/login");
    	          page.getByPlaceholder("Email").click();
    	          page.getByPlaceholder("Email").fill("dinesh@yopmail.com");
    	          page.getByPlaceholder("Password").click();
    	          page.getByPlaceholder("Password").fill("Test@123");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    	          Thread.sleep(6000);
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Listings ")).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Auction").setExact(true)).click();
    	          Thread.sleep(2000);
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add Auction")).click();
    	          Thread.sleep(2000);
    	          page.getByText("Select Manifest").click();
    	          Vendor_Manifest option = new Vendor_Manifest();
    	          page.getByRole(AriaRole.SEARCHBOX).fill(option.optionName);
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(option.optionName)).click();
    	          page.getByPlaceholder("Reserve Price").click();
    	          page.getByPlaceholder("Reserve Price").fill("10");
    	          page.getByPlaceholder("Start Bid Price").click();
    	          page.getByPlaceholder("Start Bid Price").fill("10");
    	          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Select Location")).click();
    	          page.getByRole(AriaRole.SEARCHBOX).fill("ita");
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Italy")).click();
    	          page.getByPlaceholder("End At").click();
    	          page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("31")).click();
    	          page.locator(".minuteselect").first().selectOption("13");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply")).click();
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
    	          
    	          page.close();
    	          page.context().close();
    	          playwright.close();
    	 }
    }
}
