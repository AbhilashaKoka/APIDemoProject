package utilityDemoTest.locatorstrategies;

import org.openqa.selenium.By;

public class XPATHSelectorUtility {

    // Static utility method to get XPath locators
    public static By byXPath(String xpath) {
        return By.xpath(xpath);
    }

    // Generalized dynamic locators using XPath patterns
    public static By locateByText(String text) {
        return byXPath("//*[text()='" + text + "']");
    }

    public static By locateByPartialText(String partialText) {
        return byXPath("//*[contains(text(),'" + partialText + "')]");
    }

    public static By locateByAttribute(String attribute, String value) {
        return byXPath("//*[@"+ attribute + "='" + value + "']");
    }

    public static By locateByTagAndAttribute(String tagName, String attribute, String value) {
        return byXPath("//" + tagName + "[@" + attribute + "='" + value + "']");
    }

    public static By locateByParentChild(String parentTag, String childTag) {
        return byXPath("//" + parentTag + "/" + childTag);
    }

    public static By locateByAncestorDescendant(String ancestorTag, String descendantTag) {
        return byXPath("//" + ancestorTag + "//" + descendantTag);
    }

    public static By locateByFollowingSibling(String siblingTag) {
        return byXPath("//following-sibling::" + siblingTag);
    }

    public static By locateByPrecedingSibling(String siblingTag) {
        return byXPath("//preceding-sibling::" + siblingTag);
    }
}