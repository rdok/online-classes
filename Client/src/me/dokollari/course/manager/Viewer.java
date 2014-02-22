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
