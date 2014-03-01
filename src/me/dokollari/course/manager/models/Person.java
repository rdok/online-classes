/*******************************************************************************
 *  The MIT License
 *   
 *  Copyright (c) 2014 Rizart Dokollari.
 *  
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *  
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
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
