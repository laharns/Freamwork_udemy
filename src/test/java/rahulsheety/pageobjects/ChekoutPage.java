package rahulsheety.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsheety.Abesrtcomponet.Abesrtcomponet;

public class ChekoutPage extends Abesrtcomponet {
    WebDriver driver;
    public ChekoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = ".btnn.action__submit.ng-star-inserted")
    WebElement submit;

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    WebElement selectcountry;
    By results =  By.cssSelector(".ta-results");


    public void selectcountry(String coutryName){
        Actions a = new Actions(driver);
        a.sendKeys(country,coutryName).build().perform();
        waitForElementToAppear(By.cssSelector(".ta-results"));
        selectcountry.click();
    }
    public ConfirmationPage submitOrder(){
        submit.click();
        return new ConfirmationPage(driver);
    }

}
