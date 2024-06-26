import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        WebDriverManager.chromeDriver.setup();
        String productname = "ZARA COAT 3";

        WebDriver driver = new  ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://rahulshettyacademy.com/client");
        Landingpage landingpage = new Landingpage(driver);
        landingpage.goTo();
        landingpage.loginApplication("anshika@gmail.com","Iamking@000");


       // driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("anshika@gmail.com");
       // driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Iamking@000");
       // driver.findElement(By.xpath("//input[@id='login']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = products.stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
        assert prod != null;
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> carts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = carts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productname));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".totalRow button")).click();
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        System.out.println(confirmMessage);
        //Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
    }
}
