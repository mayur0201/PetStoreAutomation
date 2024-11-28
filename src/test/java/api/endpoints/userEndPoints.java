package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class userEndPoints {


    public static Response createUser(User payload) {
       Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Route.postUrl);

       return response;
    }

    public static Response readUser(String username) {
        Response response = given()
                .pathParam("username",username)
                .when()
                .get(Route.getUrl);

        return response;
    }

    public static Response updateUser(User payload, String username) {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",username)
                .body(payload)
                .when()
                .put(Route.putUrl);

        return response;
    }

    public static Response deleteUser(String username) {
        Response response = given()
                .pathParam("username",username)
                .when()
                .delete(Route.deleteUrl);

        return response;
    }


}
