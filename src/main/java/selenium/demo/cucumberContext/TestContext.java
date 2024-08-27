package selenium.demo.cucumberContext;
import selenium.demo.pages.FileReaderManager;
import selenium.demo.pages.PageObjectManager;
import selenium.demo.pages.WebDriverManager;

public class TestContext {
    private final PageObjectManager pageObjectManager;
    private final WebDriverManager webDriverManager;
    private final FileReaderManager fileReaderManager;


    public TestContext()
    {
        webDriverManager=new WebDriverManager();
        pageObjectManager= new PageObjectManager(webDriverManager.getDriver());
        fileReaderManager=new FileReaderManager();
    }


    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
    public FileReaderManager getFileReaderManager(){return fileReaderManager;}
}
