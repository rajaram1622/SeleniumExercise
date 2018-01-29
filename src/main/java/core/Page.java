package core;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Page {

    public static String getPageTitle() {
        return Browser.driver.getTitle();
    }

    public static String getPageURL() {
        return Browser.driver.getCurrentUrl();
    }

    public static void open(String URL) {
        try {
            Browser.driver.get(URL);
        } catch (Throwable e) {
         e.printStackTrace();
        }
    }

    public static void isPageDisplayed(String expectedPage, String actualPage)  {
        Assert.assertEquals("Expected Page displayed", expectedPage,actualPage);
    }

    public void getPageCookies() {
        Browser.driver.manage().getCookies();
    }

    public void addPageCookies(Cookie cookie) {
        Browser.driver.manage().addCookie(cookie);
    }

    public void deletePageCookies(Cookie cookie) {
        Browser.driver.manage().deleteCookie(cookie);
    }

    public void deleteSpecificCookie(Cookie cookie) {
        Browser.driver.manage().deleteCookie(cookie);
    }

    public void getPageSource() {
        Browser.driver.getPageSource();
    }

    public void switchToParentFrame() {
        Browser.driver.switchTo().parentFrame();
    }

    public void switchToSpecificFrameByName(String frame) {
        Browser.driver.switchTo().frame(frame);
    }

    public void switchToSpecificFrameById(int id) {
        Browser.driver.switchTo().frame(id);
    }

    public String getPageWindowHandle() {
        return Browser.driver.getWindowHandle();
    }

    public Set<String> getPageAllWindowHandle() {
        return Browser.driver.getWindowHandles();
    }
}
