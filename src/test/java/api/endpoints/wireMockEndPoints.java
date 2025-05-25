package api.endpoints;


import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class wireMockEndPoints {



    public static Response findByStatus() {
        Response response = given()
                .queryParam("status", "available")
                .queryParam("status", "pending")
                .queryParam("status","sold")
                .when()
                .get(Route.findByStatusUrl);

        return response;
    }




}
