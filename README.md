# Selenium demoQA - spring and no-spring testing setup

The project contains Spring Boot and no-spring testing setup for demoqa.com students practice form.

## Run all tests (with default profile - chrome)

```bash
mvn clean install
```

## Run tests separately (chrome or firefox profile available)

```bash
# No-spring tests
mvn clean test -pl no-spring-testng -Ddriver=chrome

# Spring tests
mvn clean test -pl spring-testng -driver=chrome -Denv=prod
```

## Technologies

- Java
- Maven
- TestNG
- Selenium
- Spring Boot
