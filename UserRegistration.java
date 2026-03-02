public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public boolean validateLastName(String lastName) {
        return lastName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+([.][a-zA-Z0-9]+)?@[a-zA-Z0-9]+[.][a-zA-Z0-9]{2,}([.][a-zA-Z]{2,})?$");
    }

    public boolean validateMobile(String mobile) {
        return mobile.matches("^[0-9]{2} [0-9]{10}$");
    }

    public boolean validatePassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$");
    }

    public static void main(String[] args) {
        UserRegistration user = new UserRegistration();

        // UC1 - First Name
        System.out.println(user.validateFirstName("John"));              // true
        System.out.println(user.validateFirstName("jo"));                // false

        // UC2 - Last Name
        System.out.println(user.validateLastName("Doe"));                // true
        System.out.println(user.validateLastName("do"));                 // false

        // UC4 - Mobile
        System.out.println(user.validateMobile("91 9919819801"));        // true
        System.out.println(user.validateMobile("9919819801"));           // false

        // UC8 - Password All Rules
        System.out.println(user.validatePassword("Password1@"));         // true
        System.out.println(user.validatePassword("Password1"));          // false

        // UC9 - Email Samples
        System.out.println("--- Valid Emails ---");
        System.out.println(user.validateEmail("abc@bl.co.in"));          // true
        System.out.println(user.validateEmail("abc.xyz@bl.co.in"));      // true
        System.out.println(user.validateEmail("abc@bl.co"));             // true
        System.out.println(user.validateEmail("abc.xyz@bl.co"));         // true
        System.out.println(user.validateEmail("abc123@bl.co.in"));       // true

        System.out.println("--- Invalid Emails ---");
        System.out.println(user.validateEmail("abc@.co.in"));            // false
        System.out.println(user.validateEmail("abc@bl..in"));            // false
        System.out.println(user.validateEmail("abc@bl.c"));              // false
        System.out.println(user.validateEmail("abc.@bl.co.in"));         // false
        System.out.println(user.validateEmail("@bl.co.in"));             // false
        System.out.println(user.validateEmail("abc@bl@co.in"));          // false
    }
}