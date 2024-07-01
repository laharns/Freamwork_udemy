import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Landingpage {

    WebDriver driver ;

    public Landingpage(WebDriver driver){
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

    public void loginApplication(String email,String Password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(Password);
        login.click();
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");

    }

}
