package practice8_3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an Employee with various attributes like name, age, gender, etc.
 * It uses the Builder design pattern to create Employee objects in a flexible way.
 */
public class Employee {
    // Private fields to store employee information
    private String givenName;  // First name of the employee
    private String surName;    // Last name of the employee
    private int age;           // Age of the employee
    private Gender gender;     // Gender of the employee (from Gender enum)
    private Role role;         // Role of the employee (from Role enum)
    private String dept;       // Department the employee works in
    private String eMail;      // Email address of the employee
    private String phone;      // Phone number of the employee
    private String address;    // Street address of the employee
    private String city;       // City where the employee lives
    private String state;      // State where the employee lives
    private String code;       // Postal code of the employee's address

    /**
     * Builder class for creating Employee objects.
     * This is an implementation of the Builder design pattern, which allows
     * creating complex objects step by step with a fluent interface.
     */
    public static class Builder {
        // Default values for all fields
        private String givenName = "";
        private String surName = "";
        private int age = 0;
        private Gender gender = Gender.FEMALE;
        private Role role = Role.STAFF;
        private String dept = "";
        private String eMail = "";
        private String phone = "";
        private String address = "";
        private String city = "";
        private String state = "";
        private String code = "";

        // Builder methods - each returns 'this' to allow method chaining

        /**
         * Sets the given name (first name) of the employee
         *
         * @param givenName The first name to set
         * @return The Builder instance for method chaining
         */
        public Builder givenName ( String givenName ) {
            this.givenName = givenName;
            return this;
        }

        /**
         * Sets the surname (last name) of the employee
         *
         * @param surName The last name to set
         * @return The Builder instance for method chaining
         */
        public Builder surName ( String surName ) {
            this.surName = surName;
            return this;
        }

        /**
         * Sets the age of the employee
         *
         * @param val The age to set
         * @return The Builder instance for method chaining
         */
        public Builder age ( int val ) {
            age = val;
            return this;
        }

        /**
         * Sets the gender of the employee
         *
         * @param val The gender to set (from Gender enum)
         * @return The Builder instance for method chaining
         */
        public Builder gender ( Gender val ) {
            gender = val;
            return this;
        }

        /**
         * Sets the role of the employee
         *
         * @param val The role to set (from Role enum)
         * @return The Builder instance for method chaining
         */
        public Builder role ( Role val ) {
            role = val;
            return this;
        }

        /**
         * Sets the department of the employee
         *
         * @param val The department to set
         * @return The Builder instance for method chaining
         */
        public Builder dept ( String val ) {
            dept = val;
            return this;
        }

        /**
         * Sets the email address of the employee
         *
         * @param val The email to set
         * @return The Builder instance for method chaining
         */
        public Builder email ( String val ) {
            eMail = val;
            return this;
        }

        /**
         * Sets the phone number of the employee
         *
         * @param val The phone number to set
         * @return The Builder instance for method chaining
         */
        public Builder phoneNumber ( String val ) {
            phone = val;
            return this;
        }

        /**
         * Sets the street address of the employee
         *
         * @param val The address to set
         * @return The Builder instance for method chaining
         */
        public Builder address ( String val ) {
            address = val;
            return this;
        }

        /**
         * Sets the city of the employee
         *
         * @param val The city to set
         * @return The Builder instance for method chaining
         */
        public Builder city ( String val ) {
            city = val;
            return this;
        }

        /**
         * Sets the state of the employee
         *
         * @param val The state to set
         * @return The Builder instance for method chaining
         */
        public Builder state ( String val ) {
            state = val;
            return this;
        }

        /**
         * Sets the postal code of the employee
         *
         * @param val The postal code to set
         * @return The Builder instance for method chaining
         */
        public Builder code ( String val ) {
            code = val;
            return this;
        }

        /**
         * Creates a new Employee object with all the properties set in this builder
         *
         * @return A new Employee instance
         */
        public Employee build () {
            return new Employee(this);
        }
    }

    /**
     * Private default constructor - prevents direct instantiation
     * Forces users to use the Builder pattern instead
     */
    private Employee () {
        super();
    }

    /**
     * Private constructor that takes a Builder object
     * This is called by the Builder's build() method
     *
     * @param builder The Builder object containing all the properties
     */
    private Employee ( Builder builder ) {
        // Copy all values from the builder to this Employee instance
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        role = builder.role;
        dept = builder.dept;
        eMail = builder.eMail;
        phone = builder.phone;
        address = builder.address;
        city = builder.city;
        state = builder.state;
        code = builder.code;
    }

    /**
     * Gets the given name (first name) of the employee
     *
     * @return The given name
     */
    public String getGivenName () {
        return givenName;
    }

    /**
     * Gets the surname (last name) of the employee
     *
     * @return The surname
     */
    public String getSurName () {
        return surName;
    }

    /**
     * Gets the age of the employee
     *
     * @return The age
     */
    public int getAge () {
        return age;
    }

    /**
     * Gets the gender of the employee
     *
     * @return The gender (from Gender enum)
     */
    public Gender getGender () {
        return gender;
    }

    /**
     * Gets the role of the employee
     *
     * @return The role (from Role enum)
     */
    public Role getRole () {
        return role;
    }

    /**
     * Gets the department of the employee
     *
     * @return The department
     */
    public String getDept () {
        return dept;
    }

    /**
     * Gets the email address of the employee
     *
     * @return The email address
     */
    public String getEmail () {
        return eMail;
    }

    /**
     * Gets the phone number of the employee
     *
     * @return The phone number
     */
    public String getPhone () {
        return phone;
    }

    /**
     * Gets the street address of the employee
     *
     * @return The street address
     */
    public String getAddress () {
        return address;
    }

    /**
     * Gets the city of the employee
     *
     * @return The city
     */
    public String getCity () {
        return city;
    }

    /**
     * Gets the state of the employee
     *
     * @return The state
     */
    public String getState () {
        return state;
    }

    /**
     * Gets the postal code of the employee
     *
     * @return The postal code
     */
    public String getCode () {
        return code;
    }

    /**
     * Prints all employee information to the console
     */
    public void print () {
        System.out.println(
                "\nName: " + givenName + " " + surName + "\n" +
                        "Age: " + age + "\n" +
                        "Gender: " + gender + "\n" +
                        "Role: " + role + "\n" +
                        "Dept: " + dept + "\n" +
                        "eMail: " + eMail + "\n" +
                        "Phone: " + phone + "\n" +
                        "Address: " + address + "\n" +
                        "City: " + city + "\n" +
                        "State: " + state + "\n" +
                        "Code: " + code + "\n"
        );
    }

    /**
     * Returns a string representation of the employee (shorter than print())
     *
     * @return A string with basic employee information
     */
    @Override
    public String toString () {
        return "Name: " + givenName + " " + surName + "\n" + "Age: " + age + "  Gender: " + gender + "\n" + "eMail: " + eMail + "\n" + " Role: " + role + " Dept: " + dept;
    }

    /**
     * Creates a list of sample employees for testing
     *
     * @return A list containing 8 sample Employee objects
     */
    public static List<Employee> createShortList () {
        List<Employee> people = new ArrayList<>();

        people.add(
                new Builder()
                        .givenName("Bob")
                        .surName("Baker")
                        .age(23)
                        .gender(Gender.MALE)
                        .role(Role.STAFF)
                        .dept("ENG")
                        .email("bob.baker@example.com")
                        .phoneNumber("201-121-4678")
                        .address("44 4th St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("Jane")
                        .surName("Doe")
                        .age(25)
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .dept("Sales")
                        .email("jane.doe@example.com")
                        .phoneNumber("202-123-4678")
                        .address("33 3rd St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("John")
                        .surName("Doe")
                        .age(28)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("HR")
                        .email("john.doe@example.com")
                        .phoneNumber("202-123-4678")
                        .address("33 3rd St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("James")
                        .surName("Johnson")
                        .age(45)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Eng")
                        .email("james.johnson@example.com")
                        .phoneNumber("333-456-1233")
                        .address("201 2nd St")
                        .city("New York")
                        .state("NY")
                        .code("12111")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("John")
                        .surName("Adams")
                        .age(52)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Sales")
                        .email("john.adams@example.com")
                        .phoneNumber("112-111-1111")
                        .address("111 1st St")
                        .city("Braintree")
                        .state("MA")
                        .code("11111")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("Joe")
                        .surName("Bailey")
                        .age(62)
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .dept("Eng")
                        .email("joebob.bailey@example.com")
                        .phoneNumber("112-111-1111")
                        .address("111 1st St")
                        .city("Town")
                        .state("CA")
                        .code("11111")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("Phil")
                        .surName("Smith")
                        .age(55)
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .dept("HR")
                        .email("phil.smith@examp;e.com")
                        .phoneNumber("222-33-1234")
                        .address("22 2nd St")
                        .city("New Park")
                        .state("CO")
                        .code("222333")
                        .build()
        );

        people.add(
                new Builder()
                        .givenName("Betty")
                        .surName("Jones")
                        .age(65)
                        .gender(Gender.FEMALE)
                        .role(Role.EXECUTIVE)
                        .dept("Sales")
                        .email("betty.jones@example.com")
                        .phoneNumber("211-33-1234")
                        .address("22 4th St")
                        .city("New Park")
                        .state("CO")
                        .code("222333")
                        .build()
        );

        return people;
    }
}