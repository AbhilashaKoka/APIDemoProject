package selenium.demo.cucumberContext;
import selenium.demo.pages.FileReaderManager;
import selenium.demo.pages.PageObjectManager;
import selenium.demo.pages.DriverManager;

public class TestContext {
    private final PageObjectManager pageObjectManager;
    private final DriverManager driverManager;
    private final FileReaderManager fileReaderManager;


    public TestContext()
    {
        driverManager =new DriverManager();
        pageObjectManager= new PageObjectManager(driverManager.getDriver());
        fileReaderManager=new FileReaderManager();
    }


    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
    public DriverManager getWebDriverManager() {
        return driverManager;
    }
    public FileReaderManager getFileReaderManager(){return fileReaderManager;}
}
