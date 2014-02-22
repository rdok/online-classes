package me.dokollari.course.manager.models;


public class Person {
    private String lastName;
    private String firstName;
    private int id;

    public Person(String lastName, String firstName, int instructorID) throws Exception {
        setLastName(lastName);
        setFirstName(firstName);
        setId(instructorID);
    }

    Person(String lastName, String firstName) throws Exception {
        setLastName(lastName);
        setFirstName(firstName);
    }

    /**
     * sets last name after it verifies that given variable if a letter of lenght 1-45
     * @param lastName
     * @throws Exception
     */
    public void setLastName(String lastName) throws Exception {
        if (!lastName.matches("[a-zA-Z]{1,45}")) {
            throw new Exception("Last name can only contain letters of length 1-45.");
        }
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) throws Exception {
        if (!firstName.matches("[a-zA-Z]{1,45}")) {
            throw new Exception("First name can only contain letters of length 1-45.");
        }
        this.firstName = firstName;
    }

    public void setId(int id) throws Exception {
        String ID = id + "";

        if (!ID.matches("[0-9]+")) {
            throw new Exception("ID can only contain letters of length 1-45.");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

}
