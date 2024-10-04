package selenium.demo.endToendAPITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static selenium.demo.endToendAPITest.E2E_Tests.*;

public class API_TestNGTest {

    @Test
    public void Test1()
    {
        CreateUser("Abhilasha123"," Abhilash@86");
        GenerateToken("Abhilasha123"," Abhilash@86");
        AUthorizedUser("Abhilasha123"," Abhilash@86");
        Assert.assertEquals("HTTP/1.1 201 Created","HTTP/1.1 201 Created");
        Assert.assertEquals("Generate Token:HTTP/1.1 200 OK","Generate Token:HTTP/1.1 200 OK");
        Assert.assertEquals("Authorized User:HTTP/1.1 200 OK","Authorized User:HTTP/1.1 200 OK");
    }
}
