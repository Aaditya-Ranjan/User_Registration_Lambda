public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public boolean validateLastName(String lastName) {
        return lastName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public static void main(String[] args) {
        UserRegistration user = new UserRegistration();

        // UC1 - First Name
        System.out.println(user.validateFirstName("John"));   // true
        System.out.println(user.validateFirstName("jo"));     // false

        // UC2 - Last Name
        System.out.println(user.validateLastName("Doe"));     // true
        System.out.println(user.validateLastName("do"));      // false
        System.out.println(user.validateLastName("doe"));     // false
    }
}