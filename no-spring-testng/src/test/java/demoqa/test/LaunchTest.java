package demoqa.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static demoqa.test.data.Constants.*;

@Epic("DemoQA Application")
@Feature("Application Launch")
public class LaunchTest extends TestBase {

    @Test
    @Story("User can launch the application")
    @Description("Test verifies that the application launches successfully and displays the correct page title")
    void launchAppTest() {
        elementsPage.navigateTo(BASE_URL);
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(MAIN_PAGE_TITLE);
    }

}
