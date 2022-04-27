package api.automation.pet.store.steps;

import api.automation.pet.store.support.client.PetClient;
import api.automation.pet.store.support.domain.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetStepDefinitions {

    private final PetClient petClient;
    private Response listPets;

    public PetStepDefinitions() {
        petClient = new PetClient();
    }

    private void buildAndUpdatePet(String status) {
        Pet pet = Pet.builder().build();
        int id = (int)Math.floor(Math.random()*(300-1+1)+1);
        pet.setId(id);
        petClient.postPet(pet);

        pet.setStatus(status);
        Pet pendingResponse = petClient.updatePet(pet);
        assertThat(pendingResponse, is(samePropertyValuesAs(pet)));
    }

    @Given("petStore has pets available")
    public void petStoreHasPetsAvailable() {
        buildAndUpdatePet("available");
        buildAndUpdatePet("sold");
        buildAndUpdatePet("pending");
    }

    @When("user search for {word} pets")
    public void userSearchForVPets(String status){
        listPets = petClient.getPetByStatus(status);
    }

    @Then("should be returned only {word} pets")
    public void shouldBeReturnedOnlyAvailablePets(String status) {
        listPets.then().
                statusCode(200).
                body(is(not(empty()))).
                body("$", hasItem(allOf(hasEntry("status", status))));
    }
}
