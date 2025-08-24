# Selenium demoQA - spring and no-spring testing setup

The project contains Spring Boot and no-spring testing setup for demoqa.com students practice form.

## Run tests

```bash
# No-spring tests
mvn clean test -pl no-spring-testng -Denv=test-chrome

# Spring tests
mvn clean test -pl spring-testng -driver=chrome -Denv=prod
```

## Technologies

- Java
- Maven
- TestNG
- Selenium
- Spring Boot
