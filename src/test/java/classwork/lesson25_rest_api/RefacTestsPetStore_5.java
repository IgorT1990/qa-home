package classwork.lesson25_rest_api;

import classwork.lesson25_rest_api.models.Category;
import classwork.lesson25_rest_api.models.Pet;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RefacTestsPetStore_5 {


    @Test
    public void verifyBody() {
        new PetStorePetEndPoint()
                .getPetByStatus("available")
                .then()
                .assertThat()
                //.log().body()
                .body(Matchers.notNullValue());
    }

    @Test
    public void verifyExistingPetReturn200() {
        new PetStorePetEndPoint()
                .getPetById("1")
                .then()
                .log().body()
                .statusCode(200);
    }
    @Test
    public void verifyExistingPetReturn404() {
        new PetStorePetEndPoint()
                .getPetById("1")
                .then()
                .log().body()
                .statusCode(404);
    }

    @Test
    public void verifyPetCanBeCreated() {
       Category category = new Category();
       category.setName("Cats");
       category.setId(123123);

       Pet cat = new Pet();
       cat.setName("Markus");
       cat.setCategory(category);
       cat.setStatus("available");

            new PetStorePetEndPoint()
                    .createPet(cat)
                    .then()
                    .statusCode(200);
    }

    @Test
    public void verifyPetHasIdAfterCreation(){
        Pet cat = Pet.createCatPetAvailable(123333, "Markus");
        Response petResponse = new PetStorePetEndPoint()
                .createPet(cat);

        Pet petFromService = petResponse.body().as(Pet.class);
//        Assert.assertNotNull(petFromService);
//        Assert.assertNotNull(petFromService.getId());

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(petFromService.getName()).as("Name").isEqualTo("Markus");
        assertions.assertThat(petFromService.getStatus()).as("Status").isEqualTo("available");
        assertions.assertAll();
    }
}


