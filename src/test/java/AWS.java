import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class AWS {


    @Test
    public void OpenBrowser()  {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        System.out.println("Chrome browser is open");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.quit();
        System.out.println("Chrome browser is close");
        System.out.println("King of automation and ci-cd");
    }
}