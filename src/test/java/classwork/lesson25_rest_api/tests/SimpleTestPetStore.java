package classwork.lesson25_rest_api.tests;

import io.restassured.response.Response;
import org.codehaus.groovy.transform.tailrec.TernaryToIfStatementConverter;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimpleTestPetStore {

    @Test
    public void testMethod() {
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .log().uri()
                .when()
                .get("/pet/findByStatus?status=available")
                .then()
                .statusCode(200);
    }

    @Test
    public void testMethodStatusCode(){
        Response response = given()
                .log().uri()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get("/pet/findByStatus?status=available")
                .then()
                .extract().response();

        response.then().statusCode(200);
        response.getStatusCode();
    }

    @Test
    public void testMethodVerifyBody(){
        given()
                .log().uri()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get("/pet/findByStatus?status=available")
                .then()
                .assertThat().body(Matchers.notNullValue());
    }


}
