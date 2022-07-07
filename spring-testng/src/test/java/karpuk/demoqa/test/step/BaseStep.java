package karpuk.demoqa.test.step;

import karpuk.demoqa.core.page.StudentFormPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseStep {

    @Autowired
    protected WebDriver driver;
    @Autowired
    protected StudentFormPage studentFormPage;

    public void openPage(String url){
        driver.get(url);
    }

}
