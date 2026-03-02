package com.userregistration;

import java.util.function.Function;

public class UserRegistration {

    Function<String, Boolean> validateFirstName = firstName -> {
        if (firstName.matches("[A-Z][a-zA-Z]{2,}"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_FIRST_NAME,
                "Invalid First Name: " + firstName
        );
    };

    Function<String, Boolean> validateLastName = lastName -> {
        if (lastName.matches("[A-Z][a-zA-Z]{2,}"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_LAST_NAME,
                "Invalid Last Name: " + lastName
        );
    };

    Function<String, Boolean> validateEmail = email -> {
        if (email.matches("^[a-zA-Z0-9]+([.][a-zA-Z0-9]+)?@[a-zA-Z0-9]+[.][a-zA-Z0-9]{2,}([.][a-zA-Z]{2,})?$"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_EMAIL,
                "Invalid Email: " + email
        );
    };

    Function<String, Boolean> validateMobile = mobile -> {
        if (mobile.matches("^[0-9]{2} [0-9]{10}$"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_MOBILE,
                "Invalid Mobile: " + mobile
        );
    };

    Function<String, Boolean> validatePassword = password -> {
        if (password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_PASSWORD,
                "Invalid Password: " + password
        );
    };

    public static void main(String[] args) {
        UserRegistration user = new UserRegistration();

        System.out.println(user.validateFirstName.apply("John"));
        System.out.println(user.validateLastName.apply("Doe"));
        System.out.println(user.validateEmail.apply("abc@bl.co.in"));
        System.out.println(user.validateMobile.apply("91 9919819801"));
        System.out.println(user.validatePassword.apply("Password1@"));
    }
}