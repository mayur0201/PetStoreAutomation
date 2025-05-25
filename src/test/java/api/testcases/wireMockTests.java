package api.testcases;


import api.endpoints.wireMockEndPoints;

import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.Test;


public class wireMockTests {

    public Logger logger = LogManager.getLogger(wireMockTests.class);

    @Test(priority = 1)
    public void testfindByStatus() {

        logger.info("***** Successfully ***");


        Response response = wireMockEndPoints.findByStatus();


        response
                .then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);


    }


}
