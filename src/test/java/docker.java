import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class docker {
	
	@Test
	public void hpd() throws MalformedURLException, URISyntaxException
	{
	    ChromeOptions options = new ChromeOptions();
	    RemoteWebDriver driver= new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), options);
        System.out.println("Browser open");
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
	    System.out.println("Browser close");
		System.out.println("Done che boss");
	    driver.quit();
	}
}
