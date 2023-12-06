package classwork.lesson25_rest_api.tests;

import classwork.lesson25_rest_api.endpoints.PetStorePetEndPoint;
import classwork.lesson25_rest_api.models.Category;
import classwork.lesson25_rest_api.models.Pet;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


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
        Assert.assertNotNull(petFromService);
        Assert.assertNotNull(petFromService.getId());

        long idFromService = petFromService.getId();

        new PetStorePetEndPoint()
                .getPetById(String.valueOf(idFromService))
                .then()
                .log().body()
                .statusCode(200);

//        SoftAssertions assertions = new SoftAssertions();
//        assertions.assertThat(petFromService.getName()).as("Name").isEqualTo("Markus");
//        assertions.assertThat(petFromService.getStatus()).as("Status").isEqualTo("available");
//        assertions.assertAll();
    }

    @BeforeClass
    public static void cleanUp(){
        List<Pet> petList = new PetStorePetEndPoint()
                .getPetByStatus("available")
                .body()
                .jsonPath().getList("$", Pet.class);

        List<Pet> petList2 = new PetStorePetEndPoint()
                .getPetByStatus("available")
                .body()
                .jsonPath().getList("findAll {item -> item.name == 'Markus'}", Pet.class);
    }

}


