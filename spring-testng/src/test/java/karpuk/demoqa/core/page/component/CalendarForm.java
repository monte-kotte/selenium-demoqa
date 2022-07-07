package karpuk.demoqa.core.page.component;

import karpuk.demoqa.core.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class CalendarForm extends BasePage {

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthOptions;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearOptions;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[contains(@class, 'day') and not(contains(@class,'outside-month'))]")
    private List<WebElement> days;

    public void selectDateOfBirth(LocalDate date) {
        select(monthOptions, date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        select(yearOptions, String.valueOf(date.getYear()));
        days.stream()
                .filter(e -> Integer.parseInt(e.getText()) == date.getDayOfMonth())
                .findFirst()
                .get().click();
    }

    private void select(WebElement select, String text) {
        (new Select(select)).selectByVisibleText(text);
    }

}
