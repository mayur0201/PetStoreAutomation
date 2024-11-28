package api.testcases;

import api.endpoints.userEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class userTests {

    Faker faker;
    User userpayload;
    public Logger logger;


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

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostRequest() {

        logger.info("***** Creating User ***");
        Response response = userEndPoints.createUser(userpayload);


        response
                .then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("***** User is created Successfully ***");
    }

    @Test(priority = 2)
    public void getUserByName() {

        logger.info("***** Reading User ***");
        Response response = userEndPoints.readUser(this.userpayload.getUsername());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void updateUser() {
        logger.info("***** Updating User ***");
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        Response response = userEndPoints.updateUser(userpayload, this.userpayload.getUsername());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);
//        Validating request Again after update
        logger.info("***** User is updated ***");
        Response responseAfterUpdate = userEndPoints.readUser(this.userpayload.getUsername());
        responseAfterUpdate
                .then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void deleteUserByName() {

        logger.info("***** Deleting User ***");
        Response response = userEndPoints.deleteUser(this.userpayload.getUsername());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("***** User is deleted successfully ***");
    }
}
