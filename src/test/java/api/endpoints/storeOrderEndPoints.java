package api.endpoints;

import api.payload.Order;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class storeOrderEndPoints {


    public static Response createOrder(Order payload) {
       Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Route.postStoreUrl);

       return response;
    }

    public static Response readOrder(int orderID) {
        Response response = given()
                .pathParam("orderID",orderID)
                .when()
                .get(Route.getStoreUrl);

        return response;
    }



    public static Response deleteOrder(int orderID) {
        Response response = given()
                .pathParam("orderID",orderID)
                .when()
                .delete(Route.deleteStoreUrl);

        return response;
    }


}
