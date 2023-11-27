package homework.rest_api;

import homework.rest_api.model.User;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTests_1 {

    @Test
    public void createUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("Test");
        user.setFirstName("Tester");
        user.setLastName("Testovui");
        user.setEmail("test@test.com");
        user.setPassword("123456");
        user.setPhone("80679809900");
        user.setStatus(0);

        new UserEndPoints()
                .createUser(user)
                .then()
                .statusCode(200);
    }

    @Test
    public void getUser(){
        new UserEndPoints()
                .getUser("Test")
                .then()
                .assertThat()
                .log().body()
                .body(Matchers.notNullValue())
                .statusCode(200);
    }

    @Test
    public void getUserAndCheckId(){
        Response response = new UserEndPoints().getUser("Test");
        User user = response.as(User.class);

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }

}
