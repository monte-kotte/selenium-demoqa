package karpuk.demoqa.core.page;

import karpuk.demoqa.core.model.enums.Gender;
import karpuk.demoqa.core.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudentFormPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'show')]//li[@id='item-0']")
    private WebElement openPracticeFormBtn;
    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    @FindBy(xpath = "//div[@id=\"genterWrapper\"]//label")
    private List<WebElement> genderBtns;
    @FindBy(id = "userNumber")
    private WebElement mobileInput;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dobInput;
    @FindBy(id = "submit")
    private WebElement submitBtn;

    public void open() {
        openPracticeFormBtn.click();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void selectGender(Gender gender) {
        genderBtns.stream()
                .filter(e -> e.getAttribute("for").equals("gender-radio-" + gender.getPosition()))
                .forEach(e -> Utils.waitAndClickJS(e));
    }

    public void enterMobileNumber(String number) {
        mobileInput.sendKeys(number);
    }

    public void openDateOfBirthCalendar() {
        Utils.scrollToView(dobInput);
        dobInput.click();
    }

    public void submitForm() {
        Utils.waitAndClickJS(submitBtn);
    }

}
