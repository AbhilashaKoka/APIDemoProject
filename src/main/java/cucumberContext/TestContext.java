package cucumberContext;

import manager.PageObjectManager;
import manager.WebDriverManager;

public class TestContext {
    private PageObjectManager pageObjectManager;
    private WebDriverManager webDriverManager;


    public TestContext()
    {
        webDriverManager=new WebDriverManager();

        pageObjectManager= new PageObjectManager(webDriverManager.getDriver());

    }


    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
}
