package rahulsheety.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsheety.Abesrtcomponet.Abesrtcomponet;

public class LandingPage extends Abesrtcomponet {
    WebDriver driver ;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    //WebElement useremail =  driver.findElement(By.xpath("//input[@id='userEmail']"));

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errrMessage;

    public Productcatlog loginApplication(String email, String Password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(Password);
        login.click();
        Productcatlog productcatlog = new Productcatlog(driver);
        return  productcatlog;

    }

    public String  getErrorMessage(){
        waitForWebElementToAppear(errrMessage);
       return errrMessage.getText();
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");

    }
}
