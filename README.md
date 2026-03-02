# User Registration Lambda

A console-based Java application that validates user registration details using Lambda Functions.

---

## 📌 Project Description

The User Registration System validates user details like First Name, Last Name, Email, Mobile, and Password using Java Lambda Functions. The application ensures all validations are in place during user entry and throws custom exceptions for invalid inputs.

---

## ✅ Use Cases

| UC | Description |
|----|-------------|
| UC1 | Validate First Name - Starts with capital, min 3 characters |
| UC2 | Validate Last Name - Starts with capital, min 3 characters |
| UC3 | Validate Email - Format: abc.xyz@bl.co.in |
| UC4 | Validate Mobile - Country code followed by 10 digit number |
| UC5 | Validate Password - Minimum 8 characters |
| UC6 | Validate Password - At least 1 uppercase letter |
| UC7 | Validate Password - At least 1 numeric number |
| UC8 | Validate Password - Exactly 1 special character |
| UC9 | Validate all email samples |
| UC10 | JUnit Tests - Happy and Sad test cases |
| UC11 | JUnit Parameterised Tests for Email |
| UC12 | Custom Exceptions for invalid user details |
| UC13 | Refactored to use Lambda Functions for all validations |

---

## 🌿 GitFlow Branch Structure

| Branch | Purpose |
|--------|---------|
| `main` | Contains only README |
| `develop` | Contains all application code |
| `feature/UC1-validFirstName` | First Name validation |
| `feature/UC2-validLastName` | Last Name validation |
| `feature/UC3-validEmail` | Email validation |
| `feature/UC4-validMobile` | Mobile validation |
| `feature/UC5-validPasswordRule1` | Password min 8 chars |
| `feature/UC6-validPasswordRule2` | Password uppercase rule |
| `feature/UC7-validPasswordRule3` | Password numeric rule |
| `feature/UC8-validPasswordRule4` | Password special char rule |
| `feature/UC9-validateEmailSamples` | Email samples validation |
| `feature/UC10-junitTests` | JUnit Happy & Sad tests |
| `feature/UC11-parameterisedEmailTest` | Parameterised email tests |
| `feature/UC12-customExceptions` | Custom exceptions |
| `feature/UC13-lambdaValidation` | Lambda function validation |

---

## 🛠️ Tech Stack

- Java 17
- JUnit Jupiter 5.10.0
- Maven
- IntelliJ IDEA
- Git & GitFlow
- GitHub