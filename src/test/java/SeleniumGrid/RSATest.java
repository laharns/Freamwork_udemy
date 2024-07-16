package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class RSATest {
    @Test
    public void HomePageCheck() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        //caps.setPlatform(Platform.);
        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.235.2:4444").toURL(),caps );
        driver.get("http://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        //driver.findElement(By.name("q")).sendKeys("rahul shetty");
        driver.close();


    }
}
