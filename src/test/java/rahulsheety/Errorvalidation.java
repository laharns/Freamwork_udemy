package rahulsheety;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsheety.TestComponent.BaseTest;
import rahulsheety.pageobjects.CartPage;
import rahulsheety.pageobjects.Productcatlog;
import java.io.IOException;
import java.util.List;


public class Errorvalidation extends BaseTest {
    @Test(groups = {"ErrorHandling"})
    public void Loginvalidation()  throws IOException{

    landingPage.loginApplication("lhr@yopmail.com","Test123@123");
    //Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
    }
    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException
    {
        String productname = "ZARA COAT 3";
        Productcatlog productcatlog = landingPage.loginApplication("lhr@yopmail.com","Test@123");
        List<WebElement> products = productcatlog.getproductList();
        productcatlog.addproductToCart(productname);
        CartPage cart = productcatlog.goTOcart();
        Boolean match = cart.VerifyProductDisplay(productname);
        Assert.assertTrue(match);
    }

}

