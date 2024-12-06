package api.testcases;

import api.endpoints.storeOrderEndPoints;
import api.payload.Order;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class orderTests {

    Faker faker;
    Order orderpayload;
    public Logger logger;


    @BeforeClass
    public void setupData() {
        faker = new Faker();
        orderpayload = new Order();
        orderpayload.setId(faker.idNumber().hashCode());
        orderpayload.setPetId(faker.idNumber().hashCode());
        orderpayload.setQuantity(faker.name().hashCode());
        orderpayload.setShipdate(faker.date().toString());
        orderpayload.setComplete(faker.bool().bool());

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostRequest() {

        logger.info("***** Creating Order ***");
        Response response = storeOrderEndPoints.createOrder(orderpayload);


        response
                .then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("***** Order is created Successfully ***");
    }

    @Test(priority = 2)
    public void getOrderByID() {

        logger.info("***** Reading Order ***");
        Response response = storeOrderEndPoints.readOrder(this.orderpayload.getId());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test(priority = 3)
    public void deleteOrderByID() {

        logger.info("***** Deleting User ***");
        Response response = storeOrderEndPoints.deleteOrder(this.orderpayload.getId());

        response
                .then().log().all();


        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("***** Order is deleted successfully ***");
    }
}
