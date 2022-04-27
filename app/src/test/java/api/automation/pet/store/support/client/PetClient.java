package api.automation.pet.store.support.client;

import api.automation.pet.store.support.domain.Pet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PetClient {
    private static final String POST_PUT_PET_ENDPOINT = "/pet";
    private static final String GET_PET_BY_STATUS_ENDPOINT = "/pet/findByStatus?status={status}";

    public void postPet(Pet pet) {
        given().
            body(pet).
        when().
            post(POST_PUT_PET_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    public Pet updatePet(Pet pet) {
         return given().
                body(pet).
        when().
                put(POST_PUT_PET_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_OK).
                assertThat().
                extract().body().as(Pet.class);
    }

    public Response getPetByStatus(String status) {
        return given().
            pathParam("status", status).
        when().
            get(GET_PET_BY_STATUS_ENDPOINT);
    }
}
