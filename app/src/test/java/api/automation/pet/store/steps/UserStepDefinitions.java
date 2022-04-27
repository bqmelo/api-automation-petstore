package api.automation.pet.store.steps;

import api.automation.pet.store.support.client.UserClient;
import api.automation.pet.store.support.domain.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;


public class UserStepDefinitions {
    private User user;
    private final UserClient userClient;

    public UserStepDefinitions() {
        userClient = new UserClient();
    }

    @Given("the user is authenticated in the PetStore")
    public void theUserIsAuthenticatedInThePetStore() { }

    @When("try to create another user")
    public void tryToCreateAnotherUser() {
        user = User.builder().build();
        Response userResponse = userClient.postUser(user);

        userResponse.
                then().
                statusCode(200);
    }

    @Then("the new user should be created successfully")
    public void theNewUserShouldBeCreatedSuccessfully() {
        Response userReturned = userClient.getUserByUsername(user);

        userReturned.
                then().
                body("username", is(user.getUsername()));
    }
}
