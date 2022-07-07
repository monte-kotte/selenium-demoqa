package karpuk.demoqa.core.page;

import karpuk.demoqa.core.model.Gender;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import static karpuk.demoqa.core.utils.Utils.scrollToView;
import static karpuk.demoqa.core.utils.Utils.waitAndClickJS;

public class StudentFormPage extends PageBase {

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
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthOptions;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearOptions;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[contains(@class, 'day') and not(contains(@class,'outside-month'))]")
    private List<WebElement> days;
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
                .forEach(WebElement::click);
    }

    public void enterMobileNumber(String number) {
        mobileInput.sendKeys(number);
    }

    public void enterDateOfBirth(LocalDate date) {
        scrollToView(dobInput);
        dobInput.click();
        select(monthOptions, date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        select(yearOptions, String.valueOf(date.getYear()));
        days.stream()
                .filter(e -> Integer.parseInt(e.getText()) == date.getDayOfMonth())
                .findFirst()
                .get().click();
    }

    public void submitForm() {
        waitAndClickJS(submitBtn);
    }

    private void select(WebElement select, String text) {
        (new Select(select)).selectByVisibleText(text);
    }

}
