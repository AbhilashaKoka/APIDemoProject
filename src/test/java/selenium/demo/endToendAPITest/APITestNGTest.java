package selenium.demo.endToendAPITest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class APITestNGTest {

    @Test
    public void Test1()
    {
         E2E_Tests e2ETests=new E2E_Tests();
         e2ETests.CreateUser("Abhilasha124"," Abhilash@89");
         e2ETests.GenerateToken("Abhilasha124"," Abhilash@89");
         e2ETests.AUthorizedUser("Abhilasha124"," Abhilash@89");
         Assert.assertEquals("HTTP/1.1 201 Created","HTTP/1.1 201 Created");
         Assert.assertEquals("Generate Token:HTTP/1.1 200 OK","Generate Token:HTTP/1.1 200 OK");
         Assert.assertEquals("Authorized User:HTTP/1.1 200 OK","Authorized User:HTTP/1.1 200 OK");
    }

}
