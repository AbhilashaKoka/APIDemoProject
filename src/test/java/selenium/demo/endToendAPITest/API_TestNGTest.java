package selenium.demo.endToendAPITest;

import org.testng.annotations.Test;

import static selenium.demo.endToendAPITest.E2E_Tests.*;

public class API_TestNGTest {

    @Test
    public void Test1()
    {
        CreateUser("Abhilasha124"," Abhilash@85");
        GenerateToken("Abhilasha124"," Abhilash@85");
        AUthorizedUser("Abhilasha124"," Abhilash@85");
    }
}
