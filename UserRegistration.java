public class UserRegistration {

    public boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]{2,}");
    }

    public static void main(String[] args) {
        UserRegistration user = new UserRegistration();
        System.out.println(user.validateFirstName("John"));   // true
        System.out.println(user.validateFirstName("jo"));     // false
        System.out.println(user.validateFirstName("john"));   // false
    }
}