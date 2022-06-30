package karpuk.demoqa.test.context;

import karpuk.demoqa.core.driver.WebDriverMngr;
import karpuk.demoqa.test.step.BaseStep;
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
    public BaseStep baseStep(){
        return new BaseStep();
    }

    @Bean
    @Scope("prototype")
    public SoftAssertions softAssertions() {
        return new SoftAssertions();
    }

}
