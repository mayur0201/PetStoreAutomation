package api.testcases;

import api.endpoints.userEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userTest {

    Faker faker;
    User userpayload;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        userpayload = new User();
        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setPassword(faker.internet().password(5, 10));
        userpayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostRequest() {
        Response response = userEndPoints.createUser(userpayload);


        response
                .then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void getUserByName() {


        Response response = userEndPoints.readUser(this.userpayload.getUsername());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void updateUser() {

        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        Response response = userEndPoints.updateUser(userpayload, this.userpayload.getUsername());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);
//        Validating request Again after update

        Response responseAfterUpdate = userEndPoints.readUser(this.userpayload.getUsername());
        responseAfterUpdate
                .then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void deleteUserByName() {


        Response response = userEndPoints.deleteUser(this.userpayload.getUsername());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
