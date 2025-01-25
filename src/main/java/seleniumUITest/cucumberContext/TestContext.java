package seleniumUITest.cucumberContext;
import seleniumUITest.manager.FileReaderManager;
import seleniumUITest.manager.PageObjectManager;
import seleniumUITest.manager.DriverManager;

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
    public DriverManager getDriverManager() {
        return driverManager;
    }
    public FileReaderManager getFileReaderManager(){return fileReaderManager;}
}
