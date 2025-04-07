package seleniumUITest.locatorstrategies;

import org.openqa.selenium.By;

public class CSSSelectorUtility {

    // General utility method to create a CSS selector locator dynamically
    public static By byCssSelector(String selector) {
        return By.cssSelector(selector);
    }

    // Generalized dynamic locators for different patterns
    public static By locateById(String id) {
        return byCssSelector("#" + id);
    }

    public static By locateByClassName(String className) {
        return byCssSelector("." + className);
    }

    public static By locateByAttribute(String attribute, String value) {
        return byCssSelector("[" + attribute + "='" + value + "']");
    }

    public static By locateByTagAndAttribute(String tagName, String attribute, String value) {
        return byCssSelector(tagName + "[" + attribute + "='" + value + "']");
    }

    public static By locateByPartialAttribute(String attribute, String partialValue) {
        return byCssSelector("[" + attribute + "*='" + partialValue + "']");
    }

    public static By locateByParentChild(String parentTag, String childTag) {
        return byCssSelector(parentTag + " > " + childTag);
    }

    public static By locateBySibling(String precedingSiblingTag, String siblingTag) {
        return byCssSelector(precedingSiblingTag + " + " + siblingTag);
    }

    public static By locateByDescendant(String ancestorTag, String descendantTag) {
        return byCssSelector(ancestorTag + " " + descendantTag);
    }
}