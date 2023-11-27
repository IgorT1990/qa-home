package classwork.lesson25_rest_api;

import classwork.lesson25_rest_api.models.Pet;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetStorePetEndPoint {


    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(Config.PETSTORE_BASE_URL)
                .contentType(ContentType.JSON);
    }



    public Response getPetById(String id) {
        return given()
                .pathParam("petId", id)
                .when()
                .get(Config.PET_BY_ID)
                .then().extract().response();
    }

    public Response getPetByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get(Config.PET_BY_STATUS)
                .then().extract().response();
    }

    public Response createPet(Pet pet){
        String petJson = new Gson().toJson(pet);
        return given()
                .body(petJson)
                .when()
                .post(Config.CREATE_PET)
                .then().extract().response();

    }



}