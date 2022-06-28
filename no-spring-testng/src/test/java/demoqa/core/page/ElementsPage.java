package demoqa.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    @FindBy(xpath = "//li[@id='item-0']//span")
    private WebElement textBoxPageBtn;

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void openTextBoxPage() {
        textBoxPageBtn.click();
        logger.info("Text box page is opened");
    }

}
