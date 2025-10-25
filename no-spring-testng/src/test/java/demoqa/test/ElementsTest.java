package demoqa.test;

import demoqa.core.model.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static demoqa.test.data.Constants.TEST_USER;
import static demoqa.test.data.Constants.TEST_USER_INCORRECT_EMAIL;
import static demoqa.test.data.TestDataFactory.*;

public class ElementsTest extends TestBase {

    public static final String ELEMENTS_URL = "https://demoqa.com/elements";

    @Test
    void textBoxSuccessTest() throws Exception {
        User testUser = fromFile(TEST_USER, User.class);

        elementsPage.navigateTo(ELEMENTS_URL);
        elementsPage.openTextBoxPage();
        elementsService.fillTextBoxForm(testUser);
        textBoxPage.submitForm();
        User actualUser = elementsService.getTextBoxOutputUser();

        Assertions.assertThat(actualUser)
                .usingRecursiveComparison()
                .isEqualTo(testUser);
    }

    @Test
    void incorrectEmailFormatTest() throws Exception {
        User testUserWithIncorrectEmail = fromFile(TEST_USER_INCORRECT_EMAIL, User.class);

        elementsPage.navigateTo(ELEMENTS_URL);
        elementsPage.openTextBoxPage();
        elementsService.fillTextBoxForm(testUserWithIncorrectEmail);
        textBoxPage.submitForm();

        Assertions.assertThat(textBoxPage.getUserEmailInputHtmlClass()).contains("field-error");
    }

}
