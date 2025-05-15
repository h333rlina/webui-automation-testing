package stepdefinitions;

import hooks.Hooks;
import org.openqa.selenium.By;
import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("User is on the SauceDemo login page")
    public void user_is_on_the_sauce_demo_login_page() {
        Hooks.driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        Hooks.driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Hooks.driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("Clicks the login button")
    public void clicks_the_login_button() {
        Hooks.driver.findElement(By.id("login-button")).click();
    }

    @Then("User should be redirected to the inventory page")
    public void user_should_be_redirected_to_the_inventory_page() {
        boolean isInventory = Hooks.driver.getCurrentUrl().contains("inventory.html");
        assert isInventory : "User is not redirected to inventory page.";
    }

    @When("User enters invalid username or password")
    public void user_enters_invalid_username_or_password() {
        Hooks.driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        Hooks.driver.findElement(By.id("password")).sendKeys("wrong_password");
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        boolean isErrorVisible = Hooks.driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
        assert isErrorVisible : "Error message not visible.";
    }
}
