package homework.rest_api;

import homework.rest_api.endpoints.UserEndPoints;
import homework.rest_api.model.User;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserCrudTests {

    @BeforeClass
    public static void cleanUp() {
        Response response = new UserEndPoints().getUser("Test");
        new UserEndPoints().deleteUser("Test");
    }

    @Test(priority = 1)
    public void createUser(){
        // Given
        User tester = User.createNewUser();
        new UserEndPoints().createUser(tester);
        //When
       Response userResponse = new UserEndPoints().getUser(tester.getUsername());
       User userFromService = userResponse
                       .body()
                       .as(User.class);

        //Then
        Assertions.assertThat(userResponse.getStatusCode()).isEqualTo(200);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(userFromService.getUsername()).as("username").isEqualTo(tester.getUsername());
        assertions.assertThat(userFromService.getId()).as("id").isEqualTo(tester.getId());
        assertions.assertAll();

    }


    @Test(priority = 2)
    public void readUser(){
        // Given
        User tester = User.createNewUser();
        new UserEndPoints().createUser(tester);
        Response userResponse = new UserEndPoints().getUser(tester.getUsername());

        // When
        User userFromService = userResponse
                .body()
                .as(User.class);

        // Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(userFromService.getUsername()).as("username").isEqualTo(tester.getUsername());
        assertions.assertThat(userFromService.getId()).as("id").isEqualTo(tester.getId());
        assertions.assertAll();

    }

    @Test(priority = 3)
    public void updateUser(){
        // Given
        User tester = User.createNewUser();
        new UserEndPoints().createUser(tester);

        tester.setUsername("BOO");

        //When
        new UserEndPoints().updateUser("Ivan", tester);
        Response userResponse = new UserEndPoints().getUser(tester.getUsername());
        User userFromService = userResponse
                .body()
                .as(User.class);

        // Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(userFromService.getUsername()).as("username").isEqualTo(tester.getUsername());
        assertions.assertThat(userFromService.getId()).as("id").isEqualTo(tester.getId());
        assertions.assertAll();

    }

    @Test(priority = 4)
    public void deleteUser(){
        // Given
        User tester = User.createNewUser();
        new UserEndPoints().createUser(tester);

        Response userResponse = new UserEndPoints().getUser(tester.getUsername());
        User userFromService = userResponse
                .body()
                .as(User.class);

        // When
        new UserEndPoints().deleteUser(userFromService.getUsername());

        // Then
        Response userByName = new UserEndPoints().getUser(userFromService.getUsername());
        //    Assertions.assertThat(petById.statusCode()).isEqualTo(200);
        Assertions.assertThat(userByName.statusCode()).isEqualTo(404);
    }
}