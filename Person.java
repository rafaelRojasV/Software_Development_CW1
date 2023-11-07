public class Person {
    // The constructors of this class are created in here
    private String first_name;
    private String surname;
    private String email;
    public Person(String first_name, String surname, String email){
        // This method allows you to define the values of this constructors
        this.first_name = first_name;
        this.surname = surname;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
