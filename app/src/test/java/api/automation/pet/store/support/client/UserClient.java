package api.automation.pet.store.support.client;

import api.automation.pet.store.support.domain.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String POST_USER_ENDPOINT = "/user";
    private static final String GET_USER_ENDPOINT = "/user/{username}";

    public Response postUser(User user) {
         return given().
            body(user).
        when().
            post(POST_USER_ENDPOINT);
    }

    public Response getUserByUsername(User user) {
        return given().
            pathParam("username", user.getUsername()).
        when().
            get(GET_USER_ENDPOINT);
    }
}
