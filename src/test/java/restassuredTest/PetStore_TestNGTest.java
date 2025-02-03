package restassuredTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PetStore_TestNGTest {

    @Test(enabled = true)
    public void VerifyGetPetById(){
        PetStore_Tests petStoreTests=new PetStore_Tests();
        Response response=petStoreTests.getPetById("1");
        System.out.println(response.asString());

}

}
