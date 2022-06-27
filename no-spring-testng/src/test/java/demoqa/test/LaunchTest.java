package demoqa.test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LaunchTest extends TestBase {

    public static final String BASE_URL = "https://demoqa.com/";
    public static final String MAIN_PAGE_TITLE = "ToolsQA";

    @Test
    void testLaunch() {
        webDriver.get(BASE_URL);
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(MAIN_PAGE_TITLE);
    }

}
