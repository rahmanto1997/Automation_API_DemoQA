package starter.store;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PostBookSteps {
    @Steps
    PostBook PostBook;
    @Given("I am on the post book bookstore page")
    public void i_am_on_the_post_book_bookstore_page() {
    }

    @When("I enter my username and password correctly for post a book")
    public void i_enter_my_username_and_password_correctly_for_post_a_book() {
        PostBook.setBodyReq();
    }
    @When("I choose a book")
    public void i_choose_a_book() {
        PostBook.hitEndpointLogin();
    }

    @When("I click post book button")
    public void i_click_post_book_button() {
        PostBook.hitEndpointPostBook();
    }

    @Then("I succeed to add a book to my profile")
    public void i_succeed_to_add_a_book_to_my_profile() {
        PostBook.valdateEndpointPostBook();
    }
    @Then("I check the book in my profile")
    public void i_check_the_book_in_my_profile() {
        PostBook.hitEndpointGetUser();
    }
}
