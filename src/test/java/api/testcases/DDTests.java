package api.testcases;

import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTests {


    @Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
    public void testPostUser(String id, String username, String fname, String lname, String email, String pswd, String phone) {
        User userpayload = new User();
        userpayload.setId(Integer.parseInt(id));
        userpayload.setUsername(username);
        userpayload.setFirstName(fname);
        userpayload.setLastName(lname);
        userpayload.setEmail(email);
        userpayload.setPassword(pswd);
        userpayload.setPhone(phone);

        Response response = userEndPoints.createUser(userpayload);
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test(priority = 2, dataProvider = "userNames", dataProviderClass = DataProviders.class)
    public void testdeleteUserByName(String username) {

        Response response = userEndPoints.deleteUser(username);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
