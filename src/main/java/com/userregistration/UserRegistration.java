package com.userregistration;

public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        if (firstName.matches("[A-Z][a-zA-Z]{2,}"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_FIRST_NAME,
                "Invalid First Name: " + firstName
        );
    }

    public boolean validateLastName(String lastName) {
        if (lastName.matches("[A-Z][a-zA-Z]{2,}"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_LAST_NAME,
                "Invalid Last Name: " + lastName
        );
    }

    public boolean validateEmail(String email) {
        if (email.matches("^[a-zA-Z0-9]+([.][a-zA-Z0-9]+)?@[a-zA-Z0-9]+[.][a-zA-Z0-9]{2,}([.][a-zA-Z]{2,})?$"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_EMAIL,
                "Invalid Email: " + email
        );
    }

    public boolean validateMobile(String mobile) {
        if (mobile.matches("^[0-9]{2} [0-9]{10}$"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_MOBILE,
                "Invalid Mobile: " + mobile
        );
    }

    public boolean validatePassword(String password) {
        if (password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$"))
            return true;
        throw new UserRegistrationException(
                UserRegistrationException.ExceptionType.INVALID_PASSWORD,
                "Invalid Password: " + password
        );
    }

    public static void main(String[] args) {
        UserRegistration user = new UserRegistration();

        System.out.println(user.validateFirstName("John"));
        System.out.println(user.validateLastName("Doe"));
        System.out.println(user.validateEmail("abc@bl.co.in"));
        System.out.println(user.validateMobile("91 9919819801"));
        System.out.println(user.validatePassword("Password1@"));
    }
}