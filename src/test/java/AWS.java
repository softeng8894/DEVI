import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AWS {


    @Test
    public void OpenBrowser()  {
        //WebDriver driver;
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("disable-gpu");
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);
        //driver.get("https://www.google.com");
        //System.out.println("Title of the page is: " + driver.getTitle());
    	
    	   System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
           WebDriver driver = new ChromeDriver();
           driver.get("https://www.example.com");
           System.out.println("Page title is: " + driver.getTitle());
           driver.quit();
    }
}