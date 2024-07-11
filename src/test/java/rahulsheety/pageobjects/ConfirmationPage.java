package rahulsheety.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsheety.Abesrtcomponet.Abesrtcomponet;

public class ConfirmationPage extends Abesrtcomponet {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;

    public String getConfirmatioMessage(){
       //ChekoutPage cp = new ChekoutPage(driver);
        //cp.submit.click();
        return confirmationMessage.getText();
    }

}
