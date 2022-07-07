package karpuk.demoqa.test.context;

import karpuk.demoqa.core.driver.WebDriverMngr;
import karpuk.demoqa.core.page.AppHomePage;
import karpuk.demoqa.core.page.StudentFormPage;
import karpuk.demoqa.test.step.BaseStep;
import karpuk.demoqa.test.step.StudentFormStep;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:${env}.properties")
public class ConfigurationContext {

    @Bean
    public WebDriver webDriver() {
        return WebDriverMngr.getInstance();
    }
    @Bean
    @Scope("prototype")
    public SoftAssertions softAssertions() {
        return new SoftAssertions();
    }

    @Bean
    public AppHomePage appHomePage() {
        return new AppHomePage();
    }
    @Bean
    public StudentFormPage studentFormPage() {
        return new StudentFormPage();
    }

    @Bean
    public BaseStep baseStep() {
        return new BaseStep();
    }
    @Bean
    public StudentFormStep studentFormStep() {
        return new StudentFormStep();
    }

}
