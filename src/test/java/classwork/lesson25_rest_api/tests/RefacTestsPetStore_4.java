package classwork.lesson25_rest_api.tests;

import classwork.lesson25_rest_api.endpoints.PetStorePetEndPoint;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RefacTestsPetStore_4 {

    @Test
    public void verifyBody(){
        new PetStorePetEndPoint()
                .getPetByStatus("available")
                .then()
                .assertThat()
                .log().body()
                .body(Matchers.notNullValue());
    }

    @Test
    public void verifyExistingPetReturn200(){
        new PetStorePetEndPoint()
                .getPetById("1")
                .then()
                .log().body()
                .statusCode(200);

    }

    @Test
    public void verifyNotExistingPetCode404(){
        new PetStorePetEndPoint()
                .getPetById("1234124124124")
                .then()
                .log().body()
                .statusCode(404);
    }
}
