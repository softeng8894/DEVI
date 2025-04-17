import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Multiple_bid {
	
  	public static Random rand = new Random();
  	public static String Rnumber = "H" + rand.nextInt(10000);
	
	public String bidinEuro; 
	public String bidinPLN;
	public double convertEURO2GBP;
	public double convertGBP2PLN;
	public double convertPLN2GBP;
	public double convertGBP2EURO;
	public String Verification;
	public String Verification1;
	public int timeUTC;
	public int currentUTCDay;
	
	static ExtentReports extent;
    static ExtentTest test;
    

	@Test(priority = 1)
    public void OpenBrowser1() throws InterruptedException  {
		
		 Common_Browser cb = new Common_Browser();
  	     Page page = cb.Great();
 
		 try(Playwright playwright = Playwright.create())  {
    		      
			      ExtentSparkReporter spark = new ExtentSparkReporter("D:/playwright-report.html");
		          extent = new ExtentReports();
		          extent.attachReporter(spark);
		          test = extent.createTest("Testcase1");

    		      System.out.println(Rnumber);
    		      
    		      currentUTCDay = ZonedDateTime.now(ZoneOffset.UTC).getDayOfMonth();
    		      System.out.println("Current UTC date: " + currentUTCDay);
    		      
    		      ZonedDateTime utcTime = ZonedDateTime.now(ZoneOffset.UTC);
    		      int currentUTCMinute = utcTime.getMinute();
    		      timeUTC = currentUTCMinute + 5; 
    		      System.out.println("Current UTC Minute: " + timeUTC);
    		    
    	          page.navigate("https://concetto.jobalots.com/vendor/login");
    	          page.getByPlaceholder("Email").click();
    	          page.getByPlaceholder("Email").fill("dinesh@yopmail.com");
    	          page.getByPlaceholder("Password").click();
    	          page.getByPlaceholder("Password").fill("Test@123");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    	          Thread.sleep(5000);
    	          
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Listings ")).click();
    	          page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Manifest").setExact(true)).click();
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add Manifest")).click();
    	          page.getByPlaceholder("Manifest Title").click();
    	          page.getByPlaceholder("Manifest Title").fill(Rnumber);
    	          page.getByPlaceholder("Manifest SKU").fill(Rnumber);
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
    	          page.locator("#manifest_product_condition_0").selectOption("1");
    	          page.getByPlaceholder("Quantity", new Page.GetByPlaceholderOptions().setExact(true)).click();
    	          page.getByPlaceholder("Quantity", new Page.GetByPlaceholderOptions().setExact(true)).fill("2");
    	          page.getByPlaceholder("Weight (In KG)").click();
    	          page.getByPlaceholder("Weight (In KG)").fill("5000");
    	          page.getByPlaceholder("Weight (In KG)").press("Tab");
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save").setExact(true)).click();
    	          
    	          test.pass("Testcase1 is Passed");
    	          page.close();
   	              page.context().close();
		  }
		  catch (Exception e) {
			      if (page != null && !page.isClosed()) 
			      {
			      byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
	              String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
	              test.fail("Test failed: " + e.getMessage()).addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
			      extent.flush();
			      }
	    		  System.out.println("Exception occur1");
	    		  page.close();
   	              page.context().close();
	    		  System.exit(1);
		  }
		  finally  
		  {
			      cb.Closeplaywright();
	      }
		 extent.flush();
    }
	
	@Test(priority = 2)
    public void OpenBrowser2() throws InterruptedException  {
		
		 Common_Browser cb = new Common_Browser();
	     Page page = cb.Great();
		
    	 try (Playwright playwright = Playwright.create()) {
    		
    		      test = extent.createTest("Testcase2");
    	        
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
    	          page.getByRole(AriaRole.SEARCHBOX).fill(Multiple_bid.Rnumber);
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(Multiple_bid.Rnumber)).click();
    	          page.getByPlaceholder("Reserve Price").click();
    	          page.getByPlaceholder("Reserve Price").fill("10");
    	          page.getByPlaceholder("Start Bid Price").click();
    	          page.getByPlaceholder("Start Bid Price").fill("10");
    	          page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Select Location")).click();
    	          page.getByRole(AriaRole.SEARCHBOX).fill("ita");
    	          page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Italy")).click();
    	          page.getByPlaceholder("End At").click();
    	          page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(String.valueOf(currentUTCDay))).first().click();
    	          page.locator(".minuteselect").first().selectOption(String.valueOf(timeUTC));
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply")).click();
    	          page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

    	          test.pass("Testcase2 is Passed");
    	          page.close();
   	              page.context().close();
    	 }
    	 catch (Exception e) {
	    		  if (page != null && !page.isClosed()) 
			      {
			      byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
	              String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
	              test.fail("Test failed: " + e.getMessage()).addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
			      extent.flush();
			      }
   		          System.out.println("Exception occur2");
   		          page.close();
	              page.context().close();
   		          System.exit(1);
		}
    	 finally {
    		 cb.Closeplaywright();
	        }
       extent.flush();
    }
	
	@Test(priority = 3)
    public void OpenBrowser3() throws InterruptedException  {
		 
		  Common_Browser cb = new Common_Browser();
	      Page page = cb.Great();
		
	      try (Playwright playwright = Playwright.create()) {
	    	  
	    	      test = extent.createTest("Testcase3");
    		  
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
	    	    	  page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Multiple_bid.Rnumber)).click();
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
			      Thread.sleep(2000);
			      page2.locator("//*[@class='mb-0 btn btn-black']").click();
			      Thread.sleep(2000);
		          page2.getByLabel("Close").click();
		          Thread.sleep(2000);
        
		          Locator Notag1 = page2.locator("//*[@class='date d-block ms-0 mb-0 ']");
			      System.out.println("Tag Status= " + Notag1.isVisible());   
		          if (Notag1.isVisible())
		          {
		      	     bidinEuro = page2.locator("//*[@class='date d-block ms-0 mb-0 ']").innerText();
		          }
		          else
		          {
		      	     bidinEuro = page2.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
		          }
			      System.out.println("Bid in Euro = " + bidinEuro.substring(1, bidinEuro.length()));

	 	          test.pass("Testcase3 is Passed");
	 	          page.close();
  	              page.context().close();
	      }
	      catch (Exception e) {
		    	  if (page != null && !page.isClosed()) 
			      {
			      byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
	              String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
	              test.fail("Test failed: " + e.getMessage()).addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
			      extent.flush();
			      }
		          extent.flush();
    		      System.out.println("Exception occur3");
    		      page.close();
	              page.context().close();
    		      System.exit(1);
		  }
	      finally {
	    	  cb.Closeplaywright();
	        }
	      extent.flush();
    }
	
	@Test(priority = 4)
    public void OpenBrowser4() throws InterruptedException  {
		
		Common_Browser cb = new Common_Browser();
	    Page page = cb.Great();
		
		try (Playwright playwright = Playwright.create()) {
			
			  test = extent.createTest("Testcase4");
 		      
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
	            page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Multiple_bid.Rnumber)).click();
	          });
	          
 	          Thread.sleep(5000);
 	          convertEURO2GBP = Double.parseDouble(bidinEuro.substring(1, bidinEuro.length())) * 0.8545;
	          System.out.println("EURO to GBP = " + String.format("%.02f", convertEURO2GBP));
	          
	          convertGBP2PLN = convertEURO2GBP * 5.0217;
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
	          
	          test.pass("Testcase4 is Passed");
	          page.close();
	          page.context().close();
		}
		 catch (Exception e) {
			  if (page != null && !page.isClosed()) 
		      {
		      byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
              String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
              test.fail("Test failed: " + e.getMessage()).addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
		      extent.flush();
		      }
		      extent.flush();
   		      System.out.println("Exception occur4");
   		      page.close();
	          page.context().close();
   		      System.exit(1);
		}
		finally {
			cb.Closeplaywright();
        }
		extent.flush();
	}
	
	@Test(priority = 5)
    public void OpenBrowser5() throws InterruptedException  {
		
		Common_Browser cb = new Common_Browser();
	    Page page = cb.Great();
		 
		try (Playwright playwright = Playwright.create()) {
			
			   test = extent.createTest("Testcase5");
 		   
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
	           page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Multiple_bid.Rnumber)).click();
	           });
    	       
               Thread.sleep(5000);
               
               for (int i = 1; i <= 5; i++) 
               {
            	   page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bid Now!")).click();
            	   if(i == 1)
            	   {
            	     page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
            	   }
            	   
            	   Thread.sleep(2000);
 	    	       Locator Confirmpopup1 = page2.locator("//*[@class='mb-0 btn-lg w-50 btn btn-primary']");
 	    	       System.out.println("Confirm popup = " + Confirmpopup1.isVisible());
 	      
 	    	       if (Confirmpopup1.isVisible())
 		           {
 	    	    	  page2.locator("//*[@class='mb-0 btn-lg w-50 btn btn-primary']").click();
 		           }
            	   
 	    	       if(i != 1)
           	       {
           	          page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
           	       }
            	   Thread.sleep(4000);
	           
		           Locator Notag3 = page2.locator("//*[@class='date d-block ms-0 mb-0 ']");
	  	           System.out.println("Tag Status= " + Notag3.isVisible());
	 	      
	               if (Notag3.isVisible())
	               {
	             	  bidinPLN = page2.locator("//*[@class='date d-block ms-0 mb-0 ']").innerText();
	               }
	               else
	               {
	            	  bidinPLN = page2.locator("//*[@class='date d-block ms-0 mb-0 winningText']").innerText();
	               }
	                  System.out.println("Bid in PLN = " + bidinPLN.substring(2, bidinPLN.length()));
               }
               
 	           test.pass("Testcase5 is Passed");
 	           page.close();
	           page.context().close();
    	 } 
		 catch (Exception e) {
			   if (page != null && !page.isClosed()) 
		       {
		       byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
               String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
               test.fail("Test failed: " + e.getMessage()).addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
		       extent.flush();
		       }
		       extent.flush();
   		       System.out.println("Exception occur5");
   		       page.close();
	           page.context().close();
   		       System.exit(1);
		}
		finally {
			cb.Closeplaywright();
        }
		extent.flush();
	}
	
	@Test(priority = 6)
    public void OpenBrowser6() throws InterruptedException  {
		
		Common_Browser cb = new Common_Browser();
	    Page page = cb.Great();
		
		try (Playwright playwright = Playwright.create()) {
			
			   test = extent.createTest("Testcase6");
 		   
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
	           page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(Multiple_bid.Rnumber)).click();
	           });
 	       
 	           Thread.sleep(5000);
 	           convertPLN2GBP = Double.parseDouble(bidinPLN.substring(2, bidinPLN.length())) * 	0.1991;
	           System.out.println("PLN to GBP = " + String.format("%.02f", convertPLN2GBP));
	          
	           convertGBP2EURO = (convertPLN2GBP * 1.1702);
	           System.out.println("GBP to EURO = " + convertGBP2EURO);
	           BigDecimal amount2 = new BigDecimal(convertGBP2EURO);
	           BigDecimal  final2 = amount2.setScale(2,RoundingMode.DOWN);
	           System.out.println("GBP to EURO = " + final2);
	          
	           Verification1 = page2.locator("//*[@class='date d-block ms-0 mb-0 lossingText']").innerText();
	           System.out.println("Verification Amount = " + Verification1.substring(1, Verification1.length()).replace(",", ""));
	          
	           if((Double.parseDouble(Verification1.substring(1, Verification1.length()).replace(",", ""))) != (Double.parseDouble(final2.toString()))) {
	        	  Assert.fail("Bid Currency Not Match");
	           }
	           
 	           test.pass("Testcase6 is Passed");
 	           page.close();
	           page.context().close();
		} 
		 catch (Exception e) {
			   if (page != null && !page.isClosed()) 
		       {
		       byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
               String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
               test.fail("Test failed: " + e.getMessage()).addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
		       extent.flush();
		       }
		       extent.flush();
   		       System.out.println("Exception occur6");
   		       page.close();
	           page.context().close();
   		       System.exit(1);
		}
		finally {
			cb.Closeplaywright();
        }
		extent.flush();
	}
}
