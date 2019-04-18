//This class contain contact data

public class ContactData {

    //First name of the contact
    private String firstName;

    //Last name of the contact
    private String lastName;

    //Phone number of the contact
    private String phoneNumber;

    //A simple contact data handling object constructor.
    ContactData(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //Get first name of the contact
    public String getFirstName() {
        return firstName;
    }

    //Get last name of the contact
    public String getLastName() {
        return lastName;
    }

    //Get phone number of the contact
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
