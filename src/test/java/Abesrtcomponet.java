import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Abesrtcomponet {
    WebDriver driver;

    public Abesrtcomponet(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;

    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public cartpage goTOcart(){
        cartHeader.click();
        cartpage cart = new cartpage(driver);
        return cart;
    }


    public void waitForElemenetToDisapper(WebElement ele)
    {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.invisibilityOf(ele));

    }
}
