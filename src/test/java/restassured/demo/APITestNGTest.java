package restassured.demo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class APITestNGTest {
    static String username="Test45";
    static String password="Test@125";
    static  String userId;
    static  String token;
    static  String userData;

    @Test
    public void VerifyCreateUser()
    {
          E2E_Tests e2ETests=new E2E_Tests();
          userId= e2ETests.CreateUser(username,password);
          Assert.assertEquals("HTTP/1.1 201 Created","HTTP/1.1 201 Created");

    }

    @Test
    public void VerifyUserAuthorized(){
        E2E_Tests e2ETests=new E2E_Tests();
        e2ETests.AuthorizedUser(username,password);
        Assert.assertEquals("Authorized User:HTTP/1.1 200 OK","Authorized User:HTTP/1.1 200 OK");
    }

     @Test
       public void VerifyGenerateToken(){
        E2E_Tests e2ETests=new E2E_Tests();
        token=e2ETests.GenerateToken(username,password);
        Assert.assertEquals("Generate Token:HTTP/1.1 200 OK","Generate Token:HTTP/1.1 200 OK");

    }

        @Test
        public void VerifygetUserData(){
        E2E_Tests e2ETests=new E2E_Tests();
        userData= e2ETests.getUserData(userId,token);
        Assert.assertEquals("Books Details:HTTP/1.1 200 OK","Books Details:HTTP/1.1 200 OK");
       }

       @Test
    public void VerifyBooksOfUser()
    {
        E2E_Tests e2ETests=new E2E_Tests();
        List<Map<String, String>> books=e2ETests.BookofUser(token,userId);
        String bookID=e2ETests.GetBooksDetails();
        System.out.println(bookID);
    }



}
