package demoqa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchTest extends TestBase {

    public static final String BASE_URL = "https://demoqa.com/";
    public static final String MAIN_PAGE_TITLE = "ToolsQA";

    @Test
    void testLaunch() {
        webDriver.get(BASE_URL);
        Assert.assertEquals(webDriver.getTitle(), MAIN_PAGE_TITLE);
    }

}
