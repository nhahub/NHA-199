# Graduation Automation Project

## Overview
This project is a graduation automation project that uses Java, Maven and Selenium WebDriver.  
It follows the Page Object Model (POM) pattern to keep tests readable and maintainable. The project automates UI interactions (clicks, checks, navigation) for a demo E-commerce web application.

## Tech stack
- Java (Microsoft open jdk 21.0.9)
- Maven
- Selenium WebDriver
- IntelliJ IDEA 
- Browser driver (ChromeDriver)

## Project structure (important files/folders)
- `pom.xml` — Maven build file and dependencies
- `src/main/java` — main code (page objects, helpers, engine)
  - `POMpatternPages` — page object classes (example: `ProductPage.java`)
  - `engine` — Bot used by page objects
- `src/test/java` — test classes (test cases)

## Automated pages
| Page | Description | Contact |
| --- | --- | --- |
| `LoginPage` | Handles user authentication flows (login, logout, validation) | `Farida El Amir Mohammed` |
| `ProductPage` | Product listing, details and add-to-cart actions | `Ahmed Azzam Mohamed` |
| `CartPage` | Cart interactions and item management | `Doaa Mahmoud Mohamed ` |
| `CheckoutPage` | Checkout flow and payment form validations | `Ahmed Gomaa Abu-Madawy` |

## How it works (simple)
1. Page objects represent pages and UI elements.
2. `engine.Bot` (a wrapper around WebDriver) provides helper methods: click, getText, checkVisibility, etc.
3. Tests use page objects and `Bot` to perform actions.

## Prerequisites (Windows)
1. Install JDK Microsoft open jdk 21.0.9 
2. Install Maven and add it to `dependencies`in pom.xml file.
3. install selenium  to `dependencies` in pom.xml file.

## Run tests (examples)
- From IntelliJ IDEA:
  - Open the project, import Maven project, run test classes or test suite directly.


## Troubleshooting
- If tests fail to start the browser Check logs printed by tests or the `engine.Bot` for more details.

## Authors
- Ahmed Gomaa Abu-Madawy
- Ahmed Azzam Mohamed
- Doaa Mahmoud Mohamed
- Farida El Amir Mohammed
