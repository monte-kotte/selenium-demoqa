package demoqa.test;

import demoqa.core.model.User;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static demoqa.test.data.Constants.*;
import static demoqa.test.data.TestDataFactory.*;

@Epic("DemoQA Elements")
@Feature("Text Box Form")
public class ElementsTest extends TestBase {

    @BeforeMethod
    public void setUpElementsTest() {
        elementsPage.navigateTo(ELEMENTS_URL);
        elementsPage.openTextBoxPage();
    }

    @Test
    @Story("User can fill text box form with valid data")
    @Description("Test verifies that user can successfully fill the text box form with valid data and the output matches the input")
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
    @Story("Form validation for incorrect email format")
    @Description("Test verifies that the form shows an error when email has incorrect format")
    void incorrectEmailFormatTest() throws Exception {
        User testUserWithIncorrectEmail = fromFile(TEST_USER_INCORRECT_EMAIL, User.class);

        elementsService.fillTextBoxForm(testUserWithIncorrectEmail);
        textBoxPage.submitForm();

        Assertions.assertThat(textBoxPage.getUserEmailInputHtmlClass()).contains("field-error");
    }

}
