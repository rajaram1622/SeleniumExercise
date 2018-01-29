package core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    private static String chromeDriverPath;

    public static DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        chromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
        options.addArguments("--start-maximised");
        options.addArguments("--start-fullscreen");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return caps;
    }

    public static DesiredCapabilities getIECapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\IEDriverServer.exe");
        //caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        caps.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 20000);
        caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        caps.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
        caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return caps;
    }
}
