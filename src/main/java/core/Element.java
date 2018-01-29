package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Element {

    private final LocatorStrategy locatorStrategy;
    private final String actualLocator;

    Element(LocatorStrategy locatorStrategy, String actualLocator) {
        this.locatorStrategy = locatorStrategy;
        this.actualLocator = actualLocator;
    }

    static Element locatorIdentifier(String locator) {
        for (LocatorStrategy e : LocatorStrategy.values()) {
            if (locator.startsWith(e.name)) {
                return new Element(e, locator.substring(e.name.length(), locator.length()));
            }
        }
        if (locator.startsWith("/") || locator.startsWith("(/") || locator.startsWith("((/")) {
            return new Element(LocatorStrategy.byXpath, locator);
        }
        return new Element(LocatorStrategy.byCssPath, locator);
    }

    static By getElement(String element) {
        Element el = locatorIdentifier(element);
        try {
            switch (el.locatorStrategy) {
                case byClassName:
                    return new By.ByClassName(element);
                case byId:
                    return new By.ById(element);
                case byXpath:
                    return new By.ByXPath(element);
                case byName:
                    return new By.ByName(element);
                case byLinkText:
                    return new By.ByLinkText(element);
                case byTagName:
                    return new By.ByTagName(element);
                case byPartialLinkText:
                    return new By.ByPartialLinkText(element);
                case byCssPath:
                    return new By.ByCssSelector(element);
                default:
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public enum LocatorStrategy {
        byClassName("className="), byId("id="), byXpath("xpath="), byCssPath("css="), byName("name="), byLinkText(
                "linktext="), byTagName("tagname="), byPartialLinkText("partiallinktext=");

        final String name;

        LocatorStrategy(String name) {
            this.name = name;
        }
    }

    public static WebElement findElement(String Locator) {
        return Browser.driver().findElement(Element.getElement(Element.locatorIdentifier(Locator).actualLocator));
    }

    public static List<WebElement> findElements(String Locator) {
        return Browser.driver().findElements(Element.getElement(Element.locatorIdentifier(Locator).actualLocator));
    }

    public static void click(String Locator) {
        findElement(Locator).click();
    }

    public static void clear(String Locator) {
        findElement(Locator).clear();
    }

    public static void submit(String Locator) {
        findElement(Locator).submit();
    }

    public static void select(String Locator,String value) {
        Select select = new Select(findElement(Locator));
        select.selectByVisibleText(value);
    }

    public static void waitForElementToBeVisible(String locator) {
        waitForElement().until(ExpectedConditions.visibilityOf(Element.findElement(locator)));
    }

    public static void waitForElementToBeClickable(String locator) {
        waitForElement().until(ExpectedConditions.elementToBeClickable(Element.findElement(locator)));
    }

    public static void waitForElementTobeSelected(String locator) {
        waitForElement().until(ExpectedConditions.elementToBeSelected(Element.findElement(locator)));
    }

    public static boolean isElementDisplayed(String Locator) {
        try {
            findElement(Locator).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementSelected(WebElement Locator) {
        return findElement(Locator.toString()).isSelected();
    }

    public static boolean isElementEnabled(WebElement Locator) {
        try {
            findElement(Locator.toString()).isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isTextDisplayed(String text) {
        List<WebElement> list = findElements("//*[contains(text(),'" + text + "')]");
        return list.size() > 0;
    }

    public static void typeIn(String Locator, String keys) {
        findElement(Locator).clear();
        findElement(Locator).sendKeys(keys);
    }

    public static String getText(String Locator) {
        return findElement(Locator).getText();
    }

    public static int getSize(String Locator) {
        return findElements(Locator).size();
    }

    public static Wait waitForElement() {
        Wait waitForElement = new FluentWait(Browser.driver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return waitForElement;
    }
}


