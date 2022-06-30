package karpuk.demoqa.test.base;

import karpuk.demoqa.core.driver.WebDriverMngr;
import karpuk.demoqa.test.context.ConfigurationContext;
import karpuk.demoqa.test.context.ConfigurationValues;
import karpuk.demoqa.test.step.BaseStep;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

@ContextConfiguration(classes = {ConfigurationContext.class, ConfigurationValues.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringAwareTestBase extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver webDriver;
    @Autowired
    protected SoftAssertions softAssert;
    @Autowired
    protected ConfigurationValues values;

    @Autowired
    protected BaseStep baseService;

    @AfterMethod
    public void cleanUp() {
        WebDriverMngr.quitDriver();
    }

}
