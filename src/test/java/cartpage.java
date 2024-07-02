import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class cartpage extends Abesrtcomponet {
    WebDriver driver;
    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> producttitle;

    public cartpage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public Boolean VerifyProductDisplay(String productName){
        Boolean match= producttitle.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
        return match;

    }
    public Chekoutpage  gotoChekoutpage(){
        checkoutEle.click();
        return new Chekoutpage();
    }

}
