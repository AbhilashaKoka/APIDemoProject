package restassured.demo;
import bddCucumber.demo.model.Response.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class APITestNGTest{
    static String username="Test45";
    static String password="Test@125";
    static  String userId;
    static  String token;
    static  String userData;

    @Test
    public void VerifyCreateUser()
    {
          E2E_Tests e2ETests=new E2E_Tests();
          Response response=  e2ETests.CreateUser(username,password);
          //String userId = response.getBody().jsonPath().getString("userID");
          String statusLine=response.getStatusLine();
          Assert.assertEquals(statusLine,"HTTP/1.1 201 Created");

    }

    @Test
    public void VerifyUserAuthorized(){
        E2E_Tests e2ETests=new E2E_Tests();
       Response response= e2ETests.AuthorizedUser(username,password);
       String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"Authorized User:HTTP/1.1 200 OK");
    }

     @Test
       public void VerifyGenerateToken(){
         E2E_Tests e2ETests=new E2E_Tests();
         Response response=e2ETests.GenerateToken(username,password);
        // String token = JsonPath.from(response.asString()).get("token");
       //  response.getBody().as(Token.class);
         String statusLine=response.getStatusLine();
         Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");

    }

        @Test
        public void VerifygetUserData(){
        E2E_Tests e2ETests=new E2E_Tests();
       Response response= e2ETests.getUserData(userId,token);
       String body = response.body().asString();
       String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
       }

       @Test
    public void VerifyBooksOfUser() throws IOException {
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.BookofUser(token, userId);
        JsonPath.from(response.asString()).get("books");
        String bookID=e2ETests.GetBooksDetails();
           String statusLine=response.getStatusLine();
           Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }



}
