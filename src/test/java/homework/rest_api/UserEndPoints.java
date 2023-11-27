package homework.rest_api;

import com.google.gson.Gson;
import homework.rest_api.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserEndPoints {

    private RequestSpecification given(){
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(Config.USER_BASE_URL)
                .contentType(ContentType.JSON);
    }

    public Response createUser(User user){
        String userJson = new Gson().toJson(user);
        return given()
                .body(userJson)
                .when()
                .post(Config.CREATE_USER)
                .then().extract().response();
    }

    public Response getUser (String username){
        return given()
                .pathParam("username", username)
                .when()
                .get(Config.GET_USER)
                .then().extract().response();
    }

    public Response updateUser (String username, User user){
        return given()
                .pathParam("username", username)
                .body(user)
                .when()
                .put(Config.UPDATE_USER)
                .then().extract().response();
    }

    public Response deleteUser (String username){
        return given()
                .when()
                .delete(Config.DELETE_USER, username)
                .then().extract().response();
    }
}
