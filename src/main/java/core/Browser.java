package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public static WebDriver driver;

    static void openBrowser() throws Exception {
        try {
            driver = new ChromeDriver(Driver.getChromeCapabilities());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void closeBrowser() throws Exception{
        try {
            driver.quit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver driver() {
        return driver;
    }

    public static void back() {
        driver.navigate().back();
    }

    public static void navigate(String url) {
        driver.navigate().to(url);
    }

    public static void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,600)", "");
    }

    public static void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(600,0)", "");
    }

    public static void close() {
        driver.close();
    }

    public static void refresh() {
        driver.navigate().refresh();
    }
}
