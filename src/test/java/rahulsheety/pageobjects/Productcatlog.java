package rahulsheety.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsheety.Abesrtcomponet.Abesrtcomponet;

import java.util.List;

public class Productcatlog extends Abesrtcomponet {
    WebDriver driver;

    public Productcatlog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By productsBy = By.cssSelector(".mb-3");
    By addTocart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getproductList(){
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getproductByname(String productname ){
        WebElement prod = getproductList().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
        return prod;
    }
    public void addproductToCart(String productname)
    {

        WebElement prod = getproductByname(productname);
        prod.findElement(addTocart).click();
        waitForElementToAppear(toastMessage);
        waitForElemenetToDisapper(spinner);


    }
}
