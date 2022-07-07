package karpuk.demoqa.core.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static karpuk.demoqa.core.utils.Utils.scrollToView;

public class AppHomePage extends BasePage {

    @FindBy(xpath = "//h5[contains(text(),'Forms')]/parent::div")
    private WebElement openFormsPageBtn;

    public void openFormsPage() {
        scrollToView(openFormsPageBtn);
        openFormsPageBtn.click();
    }

}
