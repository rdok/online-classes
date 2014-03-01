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
package me.dokollari.course.manager;

import java.util.List;

import me.dokollari.course.manager.models.Instructor;

public class Viewer {


    static String format(List<Instructor> instructors) {
        String output = String.format("%-13s | %-13s | %-7s\n", "Last Name", "First Name", "ID");
        int currentLenght = output.length();
        for (int i = 0; i < currentLenght; i++) {
            output += "-";
        }
        output += "\n";

        String lastName;
        String firstName;
        int id;

        for (int i = 0; i < instructors.size(); i++) {

            lastName = instructors.get(i).getLastName();
            firstName = instructors.get(i).getFirstName();
            id = instructors.get(i).getId();

            System.out.println(firstName);

            output += String.format("%-13s | %-13s | %d\n", lastName, firstName, id);
        } // end for

        return output;
    }
}
