package demoqa.test;

import demoqa.core.model.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static demoqa.test.data.Constants.*;
import static demoqa.test.data.TestDataFactory.*;

public class ElementsTest extends TestBase {

    @BeforeMethod
    public void setUpElementsTest() {
        elementsPage.navigateTo(ELEMENTS_URL);
        elementsPage.openTextBoxPage();
    }

    @Test
    void textBoxSuccessTest() throws Exception {
        User testUser = fromFile(TEST_USER, User.class);

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

        elementsService.fillTextBoxForm(testUserWithIncorrectEmail);
        textBoxPage.submitForm();

        Assertions.assertThat(textBoxPage.getUserEmailInputHtmlClass()).contains("field-error");
    }

}
