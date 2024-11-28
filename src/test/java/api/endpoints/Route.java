package api.endpoints;


public class Route {

    public static String baseUrl = "https://petstore.swagger.io/v2";

//   User Modules

    public static String postUrl = baseUrl + "/user";
    public static String getUrl = baseUrl + "/user/{username}";
    public static String putUrl = baseUrl + "/user/{username}";
    public static String deleteUrl = baseUrl + "/user/{username}";

}
