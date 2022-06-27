package demoqa.test;

import demoqa.core.model.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ElementsTest extends TestBase {

    public static final String ELEMENTS_URL = "https://demoqa.com/elements";
    private User testUser = User.builder()
            .fullName("Mark Smith")
            .email("mark@dmail.com")
            .currentAddress("123 Main st")
            .permanentAddress("444 Central st")
            .build();

    @Test
    void testTextBox() {
        webDriver.get(ELEMENTS_URL);
        elementsPage.openTextBoxPage();
        elementsService.fillTextBoxForm(testUser);
        textBoxPage.submitForm();
        User actualUser = elementsService.getTextBoxOutputUser();

        Assertions.assertThat(actualUser.getFullName()).contains(testUser.getFullName());
        Assertions.assertThat(actualUser.getEmail()).contains(testUser.getEmail());
        Assertions.assertThat(actualUser.getCurrentAddress()).contains(testUser.getCurrentAddress());
        Assertions.assertThat(actualUser.getPermanentAddress()).contains(testUser.getPermanentAddress());
    }

}
