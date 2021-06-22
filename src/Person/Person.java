package Person;

public class Person {

    private int ssn;
    private String firstName;
    private String lastName;
    private int streetNum;
    private String streetName;
    private String city;
    private String state;
    private int zip;

    public Person() {

    }

    public Person(int ssn, String firstName, String lastName, int streetNum, String streetName, String city, String state, int zip) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String toString() {
        return ssn + " " + firstName + " " + lastName + " " + streetNum + " " + streetName + " " + city + " " + state + " " + zip;
    }
}
