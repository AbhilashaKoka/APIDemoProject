package serenity.demo.steps;
import net.serenitybdd.annotations.Step;
import serenity.demo.pagesObject.UploadPage;

public class UploadPageSteps {

    private UploadPage uploadPage;



    @Step
    public void InitialSetUp(){
        uploadPage.open();
    }

    @Step
    public void uploadAndDownloadMethod() throws InterruptedException {
        uploadPage.UploadLandingPage();
        uploadPage.FileUploadAndDownload();
    }
}
