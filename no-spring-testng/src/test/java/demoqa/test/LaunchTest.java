package demoqa.test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static demoqa.test.data.Constants.*;

public class LaunchTest extends TestBase {

    @Test
    void launchAppTest() {
        elementsPage.navigateTo(BASE_URL);
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(MAIN_PAGE_TITLE);
    }

}
