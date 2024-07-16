package rahulsheety.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import rahulsheety.TestComponent.BaseTest;
import rahulsheety.pageobjects.*;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class stepDefinationImplemation extends BaseTest {
    public LandingPage landingPage;
    public Productcatlog productcatlog;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce page")
    public void I_landed_on_Ecommerce_page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String username, String password) {
        productcatlog = landingPage.loginApplication(username, password);
    }

    @When("^I add product (.+) to Cart$")
    public void I_add_product_to_Cart(String productName) throws InterruptedException {
        List<WebElement> products = productcatlog.getproductList();
        productcatlog.getproductByname(productName);
        productcatlog.addproductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productName) {
        CartPage cartPage = productcatlog.goTOcart();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);

        ChekoutPage checkoutPage = cartPage.gotoChekoutpage();
        checkoutPage.selectcountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String expectedMessage) {
        String confirmMessage = confirmationPage.getConfirmatioMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(expectedMessage));
        driver.close();
    }
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {

        Assert.assertEquals(strArg1, landingPage.getErrorMessage());
        driver.close();
    }
}
