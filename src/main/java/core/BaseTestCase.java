package core;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class BaseTestCase {

    @BeforeClass
    public static void init() throws Exception {
        Browser.openBrowser();
    }

    @AfterClass
    public static void end() throws Exception {
        Browser.closeBrowser();
    }

}
