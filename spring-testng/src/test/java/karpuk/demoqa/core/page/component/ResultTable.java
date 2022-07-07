package karpuk.demoqa.core.page.component;

import karpuk.demoqa.core.model.enums.Gender;
import karpuk.demoqa.core.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ResultTable extends BasePage {

    @FindBy(xpath = "//td[text()='Student Name']/following-sibling::td")
    private WebElement fullNameTD;
    @FindBy(xpath = "//td[text()='Gender']/following-sibling::td")
    private WebElement genderTD;
    @FindBy(xpath = "//td[text()='Mobile']/following-sibling::td")
    private WebElement mobileTD;
    @FindBy(xpath = "//td[text()='Date of Birth']/following-sibling::td")
    private WebElement dateOfBirthTD;

    public String getFullName() {
        return fullNameTD.getText();
    }

    public Gender getGender() {
        return Gender.valueOf(genderTD.getText().toUpperCase());
    }

    public String getMobile() {
        return mobileTD.getText();
    }

    public LocalDate getDateOfBirth() {
        return LocalDate.parse(dateOfBirthTD.getText(), DateTimeFormatter.ofPattern("dd MMMM,yyyy"));
    }

}
