package starter.account;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class loginSteps {

    @Steps
    login login;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

    }

    @When("I enter my username and password correctly")
    public void i_enter_my_username_and_password_correctly() {
        login.setBodyReq();
    }

    @When("I click {string} button")
    public void i_click_button(String string) {
        login.hitEndpointLogin();
    }

    @Then("I am redirected to the dashboard")
    public void i_am_redirected_to_the_dashboard() {
        login.valdateEndpointLogin();
    }

    @Then("I get user Id")
    public void i_get_user_Id() {
        login.hitEndpointGetUser();
    }

}
