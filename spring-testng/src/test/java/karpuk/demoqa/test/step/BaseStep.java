package karpuk.demoqa.test.step;

import karpuk.demoqa.core.page.StudentFormPage;
import karpuk.demoqa.core.page.component.CalendarForm;
import karpuk.demoqa.core.page.component.ResultTable;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseStep {

    @Autowired
    protected WebDriver driver;
    @Autowired
    protected StudentFormPage studentFormPage;
    @Autowired
    protected CalendarForm calendarForm;
    @Autowired
    protected ResultTable resultTable;

    public void openPage(String url) {
        driver.get(url);
    }

}
