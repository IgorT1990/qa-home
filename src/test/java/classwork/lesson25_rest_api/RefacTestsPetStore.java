package classwork.lesson25_rest_api;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RefacTestsPetStore {

    @Test
    public void verifyStatusCode(){
        given()
                .log().uri()
                .baseUri(Config.PETSTORE_BASE_URL)
                .queryParam("status", "available")
                .when()
                .get(Config.PET_BY_STATUS)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBody(){
        given()
                .log().uri()
                .baseUri(Config.PETSTORE_BASE_URL)
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
                .log().uri()
                .baseUri(Config.PETSTORE_BASE_URL)
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
                .log().uri()
                .baseUri(Config.PETSTORE_BASE_URL)
                .pathParam("petId", "123123123123123")
                .when()
                .get(Config.PET_BY_ID)
                .then()
                .log().body()
                .statusCode(404);
    }


}
