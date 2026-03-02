package com.userregistration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    UserRegistration user = new UserRegistration();

    // UC1 - First Name
    @Test
    public void givenValidFirstName_ShouldReturnTrue() {
        assertTrue(user.validateFirstName.apply("John"));
    }

    @Test
    public void givenInvalidFirstName_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validateFirstName.apply("jo"));
    }

    @Test
    public void givenFirstNameWithNoCapital_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validateFirstName.apply("john"));
    }

    // UC2 - Last Name
    @Test
    public void givenValidLastName_ShouldReturnTrue() {
        assertTrue(user.validateLastName.apply("Doe"));
    }

    @Test
    public void givenInvalidLastName_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validateLastName.apply("do"));
    }

    @Test
    public void givenLastNameWithNoCapital_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validateLastName.apply("doe"));
    }

    // UC3 - Email
    @Test
    public void givenValidEmail_ShouldReturnTrue() {
        assertTrue(user.validateEmail.apply("abc@bl.co.in"));
    }

    @Test
    public void givenInvalidEmail_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validateEmail.apply("abc@.co.in"));
    }

    // UC4 - Mobile
    @Test
    public void givenValidMobile_ShouldReturnTrue() {
        assertTrue(user.validateMobile.apply("91 9919819801"));
    }

    @Test
    public void givenInvalidMobile_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validateMobile.apply("9919819801"));
    }

    // UC5-UC8 - Password
    @Test
    public void givenValidPassword_ShouldReturnTrue() {
        assertTrue(user.validatePassword.apply("Password1@"));
    }

    @Test
    public void givenPasswordWithNoUpperCase_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validatePassword.apply("password1@"));
    }

    @Test
    public void givenPasswordWithNoNumber_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validatePassword.apply("Password@"));
    }

    @Test
    public void givenPasswordWithNoSpecialChar_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validatePassword.apply("Password1"));
    }

    @Test
    public void givenPasswordWithLessThan8Chars_ShouldThrowException() {
        assertThrows(UserRegistrationException.class, () -> user.validatePassword.apply("Pass1@"));
    }

    // UC11 - Parameterised Email Test
    @ParameterizedTest
    @CsvSource({
            "abc@bl.co.in, true",
            "abc.xyz@bl.co.in, true",
            "abc@bl.co, true",
            "abc.xyz@bl.co, true",
            "abc123@bl.co.in, true"
    })
    public void givenValidEmailSamples_ShouldReturnTrue(String email, boolean expected) {
        assertEquals(expected, user.validateEmail.apply(email));
    }

    @ParameterizedTest
    @CsvSource({
            "abc@.co.in",
            "abc@bl..in",
            "abc@bl.c",
            "@bl.co.in",
            "abc@bl@co.in"
    })
    public void givenInvalidEmailSamples_ShouldThrowException(String email) {
        assertThrows(UserRegistrationException.class, () -> user.validateEmail.apply(email));
    }
}