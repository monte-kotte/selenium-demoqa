package karpuk.demoqa.test.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:${env}.properties")
public class ConfigurationValues {

    @Value("${application.url}")
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

}
