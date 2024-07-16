package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class GoogleTest {
    @Test
    public void HomePageCheck()throws MalformedURLException, URISyntaxException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        //caps.setPlatform(Platform.);
        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.235.2:4444").toURL(),caps );
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("rahul shetty");
        driver.close();


    }
}
