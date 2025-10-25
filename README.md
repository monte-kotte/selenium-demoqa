# Selenium demoQA - spring and no-spring testing setup

The project provides two independent modules for testing the demoqa.com students practice form:

- One uses Spring Context and Spring Test for integration.
- The other follows a no-spring approach with plain TestNG and Selenium.

## Run all tests (with default profile - chrome)

```bash
mvn clean install
```

## Run tests separately (chrome or firefox profile available)

```bash
# Run no-spring tests and generate allure report
mvn clean test -pl no-spring-testng -Ddriver=chrome
mvn allure:serve -pl no-spring-testng

# Run spring-based tests
mvn clean test -pl spring-testng -Ddriver=chrome -Denv=prod
```

## Technologies

- Java 21
- Maven
- Selenium
- TestNG
- Assertj
- Lombok
- Spring (for one of the modules)
