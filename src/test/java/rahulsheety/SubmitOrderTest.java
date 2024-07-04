package rahulsheety;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsheety.TestComponent.BaseTest;
import rahulsheety.pageobjects.*;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.Duration;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productname = "ZARA COAT 3";
    //public static void main(String[] args)  {
//        WebDriverManager.chromeDriver.setup();
    @Test
    public void submitorder() throws IOException {

        // LandingPage landingpage =  launchApplication();

        // WebDriver driver = new  ChromeDriver();
        // driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.get("https://rahulshettyacademy.com/client");
        LandingPage landingpage = new LandingPage(driver);
        //landingpage.goTo();
        // landingpage.loginApplication("anshika@gmail.com","Iamking@000");
        Productcatlog productcatlog = landingpage.loginApplication("lhr@yopmail.com", "Test@123");

        // Productcatlog productcatlog = new Productcatlog(driver);
        // List<WebElement> products = productcatlog.getproductList();
        productcatlog.addproductToCart(productname);

        CartPage cart = productcatlog.goTOcart();
        //productcatlog.goTOcart();

        //cartpage cart = new cartpage(driver);
        Boolean match = cart.VerifyProductDisplay(productname);
        Assert.assertTrue(match);

        ChekoutPage chekoutpage = cart.gotoChekoutpage();
        chekoutpage.selectcountry("india");

        ConfirmationPage confirmationPage = chekoutpage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmatioMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods= {"submitorder"})
    public void OrderHistoryTest()
    {
        Productcatlog productcatlog = landingPage.loginApplication("lhr@yopmail.com", "Test@123");
        OrderPage ordersPage = productcatlog.goTOOrdersPage();
        Assert.assertTrue(ordersPage.VerifyOrderDisplay(productname));

    }
}
        // driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("anshika@gmail.com");
        // driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Iamking@000");
        // driver.findElement(By.xpath("//input[@id='login']")).click();

        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        //List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        //WebElement prod = products.stream().filter(product->
        //      product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
        //assert prod != null;
        //prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

        // driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        //List<WebElement> carts = driver.findElements(By.cssSelector(".cartSection h3"));
        //Boolean match = carts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productname));

        //Assert.assertTrue(match);
        //driver.findElement(By.cssSelector(".totalRow button")).click();
        //Actions a = new Actions(driver);
        //a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        //driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        // driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
        // String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        //Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        //System.out.println(confirmMessage);
        //Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");

