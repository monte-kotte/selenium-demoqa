package demoqa.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static demoqa.core.utils.Utils.scrollToView;

public class TextBoxPage extends BasePage {

    @FindBy(id = "userName")
    private WebElement fullNameInput;
    @FindBy(id = "userEmail")
    private WebElement emailInput;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressTextArea;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressTextArea;
    @FindBy(id = "submit")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@id='output']//p[@id='name']")
    private WebElement outputUserName;
    @FindBy(xpath = "//div[@id='output']//p[@id='email']")
    private WebElement outputUserEmail;
    @FindBy(xpath = "//div[@id='output']//p[@id='currentAddress']")
    private WebElement outputCurrentAddress;
    @FindBy(xpath = "//div[@id='output']//p[@id='permanentAddress']")
    private WebElement outputPermanentAddress;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void enterFullName(String fullName) {
        fullNameInput.sendKeys(fullName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterCurrentAddress(String address) {
        currentAddressTextArea.sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        permanentAddressTextArea.sendKeys(address);
    }

    public void submitForm() {
        scrollToView(submitBtn);
        submitBtn.click();
    }

    public String getOutputName() {
        return outputUserName.getText();
    }

    public String getOutputEmail() {
        return outputUserEmail.getText();
    }

    public String getOutputCurrentAddress(){
        return outputCurrentAddress.getText();
    }

    public String getOutputPermanentAddress(){
        return outputPermanentAddress.getText();
    }

}
