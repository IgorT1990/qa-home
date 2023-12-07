package classwork.lesson25_rest_api;
import classwork.lesson25_rest_api.endpoints.PetStorePetEndPoint;
import classwork.lesson25_rest_api.models.Pet;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CrudTests {

    @BeforeClass
    public static void cleanUp(){
        List<Pet> petListAvailable = new PetStorePetEndPoint()
                .getPetByStatus("available")
                .body()
                .jsonPath().getList("$", Pet.class);

        petListAvailable.stream().filter(pet -> "Murchyk100".equals(pet.getName()))
                .forEach(pet -> new PetStorePetEndPoint().deleteById(pet.getId()));

        List<Pet> petListSold = new PetStorePetEndPoint()
                .getPetByStatus("sold")
                .body()
                .jsonPath().getList("$", Pet.class);

        petListSold.stream().filter(pet -> "Murchyk100".equals(pet.getName()))
                .forEach(pet -> new PetStorePetEndPoint().deleteById(pet.getId()));



//        List<Pet> petList3 = new PetStorePetEndPoint()
//                .getPetByStatus("available")
//                .body()
//                .jsonPath().getList("findAll {item -> item.name == 'Murchyk100'}", Pet.class);
//
//        for (Pet pet : petList3){
//            new PetStorePetEndPoint().deleteById(pet.getId());
//        }

        System.out.println();
    }

    @Test(priority = 1)
    public void createPet(){
        // Given
        Pet murchyk = Pet.createCatPetAvailable(123125, "Murchyk100");
        // When
        Response petResponse = new PetStorePetEndPoint()
                .createPet(murchyk);
        //Then
        long createdPetId = petResponse
                .body()
                .as(Pet.class)
                .getId();

        Pet petCreatedFromService = new PetStorePetEndPoint()
                .getPetById(String.valueOf(createdPetId))
                .as(Pet.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(petCreatedFromService.getName()).as("Name").isEqualTo(murchyk.getName());
        assertions.assertThat(petCreatedFromService.getStatus()).as("Status").isEqualTo(murchyk.getStatus());
        assertions.assertAll();
    }

    @Test(priority = 2)
    public void readPet(){
        // Given
        Pet murchyk = Pet.createCatPetAvailable(123125, "Murchyk100");
        Response petResponse = new PetStorePetEndPoint()
                .createPet(murchyk);
        long createdPetId = petResponse
                .body()
                .as(Pet.class)
                .getId();

        // When
        Pet petCreatedFromService = new PetStorePetEndPoint()
                .getPetById(String.valueOf(createdPetId))
                .as(Pet.class);

        // Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(petCreatedFromService.getName()).as("Name").isEqualTo(murchyk.getName());
        assertions.assertThat(petCreatedFromService.getStatus()).as("Status").isEqualTo(murchyk.getStatus());
        assertions.assertAll();

    }

    @Test(priority = 3)
    public void updatePet(){
        // Given
        Pet murchyk = Pet.createCatPetAvailable(123125, "Murchyk200");
        Response petResponse = new PetStorePetEndPoint()
                .createPet(murchyk);

        murchyk.setStatus("sold");

        //When
        Pet createdFromService = new PetStorePetEndPoint()
                .updatePet(murchyk).body().as(Pet.class);

        // Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdFromService.getName()).as("Name").isEqualTo(murchyk.getName());
        assertions.assertThat(createdFromService.getStatus()).as("Status").isEqualTo(murchyk.getStatus());
        assertions.assertAll();

    }

    @Test(priority = 4)
    public void deletePet(){
        // Given
        Pet murchyk = Pet.createCatPetAvailable(123125, "Murchyk125");
        Response petResponse = new PetStorePetEndPoint()
                .createPet(murchyk);

        long createdPetId = petResponse
                .body()
                .as(Pet.class)
                .getId();
        Pet createdFromService = new PetStorePetEndPoint()
                .getPetById(String.valueOf(createdPetId))
                .as(Pet.class);

        // When
        new PetStorePetEndPoint().deleteById(createdFromService.getId());

        // Then
        Response petById = new PetStorePetEndPoint().getPetById(String.valueOf(createdFromService.getId()));
    //    Assertions.assertThat(petById.statusCode()).isEqualTo(200);
        Assertions.assertThat(petById.statusCode()).isEqualTo(404);
    }
}
