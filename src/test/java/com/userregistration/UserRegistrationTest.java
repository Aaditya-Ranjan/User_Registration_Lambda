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
        assertTrue(user.validateFirstName("John"));
    }

    @Test
    public void givenInvalidFirstName_ShouldReturnFalse() {
        assertFalse(user.validateFirstName("jo"));
    }

    @Test
    public void givenFirstNameWithNoCapital_ShouldReturnFalse() {
        assertFalse(user.validateFirstName("john"));
    }

    // UC2 - Last Name
    @Test
    public void givenValidLastName_ShouldReturnTrue() {
        assertTrue(user.validateLastName("Doe"));
    }

    @Test
    public void givenInvalidLastName_ShouldReturnFalse() {
        assertFalse(user.validateLastName("do"));
    }

    @Test
    public void givenLastNameWithNoCapital_ShouldReturnFalse() {
        assertFalse(user.validateLastName("doe"));
    }

    // UC3 - Email
    @Test
    public void givenValidEmail_ShouldReturnTrue() {
        assertTrue(user.validateEmail("abc@bl.co.in"));
    }

    @Test
    public void givenValidEmailWithOptionalParts_ShouldReturnTrue() {
        assertTrue(user.validateEmail("abc.xyz@bl.co.in"));
    }

    @Test
    public void givenInvalidEmailMissingAt_ShouldReturnFalse() {
        assertFalse(user.validateEmail("abc@.co.in"));
    }

    @Test
    public void givenInvalidEmailDoubleDot_ShouldReturnFalse() {
        assertFalse(user.validateEmail("abc@bl..in"));
    }

    // UC4 - Mobile
    @Test
    public void givenValidMobile_ShouldReturnTrue() {
        assertTrue(user.validateMobile("91 9919819801"));
    }

    @Test
    public void givenMobileWithoutCountryCode_ShouldReturnFalse() {
        assertFalse(user.validateMobile("9919819801"));
    }

    @Test
    public void givenMobileWithInsufficientDigits_ShouldReturnFalse() {
        assertFalse(user.validateMobile("91 99198"));
    }

    // UC5-UC8 - Password
    @Test
    public void givenValidPassword_ShouldReturnTrue() {
        assertTrue(user.validatePassword("Password1@"));
    }

    @Test
    public void givenPasswordWithNoUpperCase_ShouldReturnFalse() {
        assertFalse(user.validatePassword("password1@"));
    }

    @Test
    public void givenPasswordWithNoNumber_ShouldReturnFalse() {
        assertFalse(user.validatePassword("Password@"));
    }

    @Test
    public void givenPasswordWithNoSpecialChar_ShouldReturnFalse() {
        assertFalse(user.validatePassword("Password1"));
    }

    @Test
    public void givenPasswordWithLessThan8Chars_ShouldReturnFalse() {
        assertFalse(user.validatePassword("Pass1@"));
    }

    @Test
    public void givenPasswordWithMoreThan1SpecialChar_ShouldReturnFalse() {
        assertFalse(user.validatePassword("Password1@@"));
    }

    // UC11 - Parameterised Email Test
    @ParameterizedTest
    @CsvSource({
            "abc@bl.co.in, true",
            "abc.xyz@bl.co.in, true",
            "abc@bl.co, true",
            "abc.xyz@bl.co, true",
            "abc123@bl.co.in, true",
            "abc@.co.in, false",
            "abc@bl..in, false",
            "abc@bl.c, false",
            "abc.@bl.co.in, false",
            "@bl.co.in, false",
            "abc@bl@co.in, false"
    })
    public void givenEmailSamples_ShouldValidateCorrectly(String email, boolean expected) {
        assertEquals(expected, user.validateEmail(email));
    }
}