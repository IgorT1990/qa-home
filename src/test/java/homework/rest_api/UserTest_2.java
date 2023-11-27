package homework.rest_api;

import homework.rest_api.model.User;
import org.testng.annotations.Test;

public class UserTest_2 {

    @Test
    public void createUser() {
        User user = new User();
        user.setId(13);
        user.setUsername("Boo");
        user.setFirstName("Ivan");
        user.setLastName("Petrenko");
        user.setEmail("tet@tet.com");
        user.setPassword("90102030");
        user.setPhone("3898090089");
        user.setStatus(0);

        new UserEndPoints()
                .createUser(user)
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteUser(){
        new UserEndPoints()
                .deleteUser("Boo")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void checkDeletedUser(){
        new UserEndPoints()
                .getUser("Boo")
                .then()
                .assertThat()
                .statusCode(404);
    }
}
