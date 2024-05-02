import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class APPIUMAPK {

	@Test
	public void Valid_login() throws MalformedURLException, URISyntaxException, InterruptedException
	{
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	     capabilities.setCapability("platformName", "Android");
	     capabilities.setCapability("deviceName","Android Emulator");
	     capabilities.setCapability("app", "D:\\himanshu backup\\fovero.apk");
	     capabilities.setCapability("autoGrantPermissions", true);
	     AndroidDriver cmok = new AndroidDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), capabilities);

	     Thread.sleep(3000);
	     WebElement Email = cmok.findElement(By.xpath("//android.view.View[@content-desc=\"App Ver 1.13\"]/android.view.View/android.widget.EditText[1]"));
	     Email.click();
	     Email.sendKeys("himanshu.patel@concettolabs.com");
	     cmok.hideKeyboard();
	     
	     Thread.sleep(1000);
	     WebElement Password = cmok.findElement(By.xpath("//android.view.View[@content-desc=\"App Ver 1.13\"]/android.view.View/android.widget.EditText[2]"));
	     Password.click();
	     Password.sendKeys("$Pilot8894$");
	     cmok.hideKeyboard();
	     
	     Thread.sleep(1000);
	     WebElement Login = cmok.findElement(By.xpath("//android.view.View[@content-desc=\"LOGIN\"]"));
	     Login.click();
	     Thread.sleep(3000);
	    
	     try 
	     {
			boolean t = cmok.findElement(By.xpath("//android.view.View[@content-desc=\"Himanshu Patel\"]")).isDisplayed();
		 }
	     catch (Exception e) 
	     {
			System.out.println("User Not Match");
			Assert.fail();
		 }
	}
}
