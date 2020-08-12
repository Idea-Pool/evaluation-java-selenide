# evaluation-java-selenide

## Prerequisites

1. Java JDK v8
1. Maven 3

## Framework used

- Name: Selenide Framework
- Home page: https://selenide.org/
- Documentation: https://selenide.org/documentation.html
- Quick tutorial: https://vimeo.com/107647158
- Selenide is a framework for test automation powered by Selenium WebDriver that brings the following advantages:
    - Concise fluent API for tests Ajax support for stable tests Powerful selectors.
    - Simple configuration. 
    - You don't need to think how to shutdown browser, handle timeouts and StaleElementExceptions or search for relevant log lines, debugging your tests.
    - Just focus on your business logic and let Selenide do the rest!

## Test cases

The implemented test cases can be found in [TESTCASES.md](TESTCASES.md).

## Setup
- `mvn install`

## Execution

- run `mvn test` to execute any tests (by default files named `**/*Test.java`), using the surefire plugin
