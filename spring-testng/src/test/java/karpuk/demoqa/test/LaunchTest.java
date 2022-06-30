package karpuk.demoqa.test;

import karpuk.demoqa.test.base.SpringAwareTestBase;
import org.testng.annotations.Test;

public class LaunchTest extends SpringAwareTestBase {

    public static final String MAIN_PAGE_TITLE = "ToolsQA";

    @Test()
    void appLaunchSuccessTest() {
        baseService.openPage(values.getBaseUrl());
        softAssert.assertThat(webDriver.getTitle()).isEqualTo(MAIN_PAGE_TITLE);
        softAssert.assertAll();
    }

}
