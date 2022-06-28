package demoqa.test.service;

import demoqa.core.model.User;
import org.openqa.selenium.WebDriver;

public class ElementsService extends BaseService {

    public ElementsService(WebDriver driver) {
        super(driver);
    }

    public void fillTextBoxForm(User user){
        textBoxPage.enterFullName(user.getFullName());
        textBoxPage.enterEmail(user.getEmail());
        textBoxPage.enterCurrentAddress(user.getCurrentAddress());
        textBoxPage.enterPermanentAddress(user.getPermanentAddress());
        logger.info("Form is filled with the next data: " + user);
    }

    public User getTextBoxOutputUser(){
        return User.builder()
                .fullName(textBoxPage.getOutputName())
                .email(textBoxPage.getOutputEmail())
                .currentAddress(textBoxPage.getOutputCurrentAddress())
                .permanentAddress(textBoxPage.getOutputPermanentAddress())
                .build();
    }
}
