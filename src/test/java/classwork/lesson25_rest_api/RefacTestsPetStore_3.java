package classwork.lesson25_rest_api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RefacTestsPetStore_3 {
    public RequestSpecification given(){
        return RestAssured.given()
                .log().uri()
                .baseUri(Config.PETSTORE_BASE_URL);
    }

    @Test
    public void verifyStatusCode(){
        given()
                .queryParam("status", "available")
                .when()
                .get(Config.PET_BY_STATUS)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBody(){
        given()
                .queryParam("status", "sold")
                .when()
                .get(Config.PET_BY_STATUS)
                .then()
                .assertThat()
                .log().body()
                .body(Matchers.notNullValue());
    }

    @Test
    public void verifyExistingPetReturn200(){
        given()
                .pathParam("petId", "1")
                .when()
                .get(Config.PET_BY_ID)
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void nonExistingPetReturn404(){
        given()
                .pathParam("petId", "123123123123123")
                .when()
                .get(Config.PET_BY_ID)
                .then()
                .log().body()
                .statusCode(404);
    }
}
