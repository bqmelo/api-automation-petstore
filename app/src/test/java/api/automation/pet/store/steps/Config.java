package api.automation.pet.store.steps;

import api.automation.pet.store.support.config.ConfigManager;
import api.automation.pet.store.support.config.ServerConfig;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class Config {

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        ServerConfig properties = ConfigManager.getConfiguration();

        RestAssured.baseURI = String.format("%s:%d", properties.baseURI(), properties.port());
        RestAssured.basePath = properties.basePath();

        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("api_key", getToken()).
                setContentType(ContentType.JSON).
                build();

        RestAssured.responseSpecification = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                build();
    }

    private String getToken() {
        return "token";
    }
}
