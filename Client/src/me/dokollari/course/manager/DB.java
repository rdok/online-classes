package me.dokollari.course.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import me.dokollari.course.manager.models.Instructor;


public class DB {
    public static String SELECT_STUDENTS = "SELECT * FROM collegedb.students;";
    public static String SELECT_INSTRUCTORS = "SELECT * FROM collegedb.instructors ORDER BY last_name ASC;";
    public static final String ID = "id";
    public static final String LAST_NAME = "last_name";
    public static final String FIRST_NAME = "first_name";

    // domain: db4free, port 3306
    // db_name: a1830231hosp
    private static final String _DB_CONNECTION = "jdbc:mysql://db4free.net:3306/collegedb";
    private static final String _DB_USER = "admincollegedb";
    private static final String _DB_PASSWORD = "NPbpQwdSyBkgLC6pgsWq";

    private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/collegedb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public DB() {
        try {
            readDatabase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readDatabase() throws Exception {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectSQL = "SELECT * FROM patients";


        connection = getDBConnection();
        preparedStatement = connection.prepareStatement(selectSQL);
        // preparedStatement.setInt(1, 1001);

        // execute select SQL statement
        resultSet = preparedStatement.executeQuery(selectSQL);

        while (resultSet.next()) {
            String patientId = resultSet.getString("id_app");
            String patientSurgery = resultSet.getString("surgery");

            System.out.printf("Patient id: %s\tPatient surgery: %s", patientId, patientSurgery);
        }
    }

    /**
     * source:
     * http://www.mkyong.com/jdbc/jdbc-preparestatement-example-select-list
     * -of-the-records/
     *
     * @return
     */
    private static Connection getDBConnection() throws SQLException {
        Connection connection = null;

        Properties connectionProps = new Properties();
        connectionProps.put("user", DB_USER);
        connectionProps.put("password", DB_PASSWORD);

        // try {
        connection = DriverManager.getConnection(DB_CONNECTION, connectionProps);
        //} catch (SQLException e) {
        // TODO Auto-generated catch block
        //            FrameMainLabReservation.setActivityMessagea("An internal error detected. Hover for more.");
        //            FrameMainLabReservation.setActivitToolTip(e.getMessage());
        //        }

        return connection;
    }

    /**
     *
     * @param jL_message update this label to inform the user on internal operations.
     * @return set of students
     * @throws SQLException
     */
    static ResultSet getStudents(JLabel jL_message) throws SQLException {
        jL_message.setText("Retrieving Student Data");

        Connection connection;
        connection = getDBConnection();

        Statement statement_insertStudents = connection.createStatement();
        ResultSet resultSet = statement_insertStudents.executeQuery(DB.SELECT_STUDENTS);

        jL_message.setText("Retrieved Student Data");
        return resultSet;
    }

    static void insertInstructor(Instructor instructor, JLabel jL_message) throws SQLException {
        jL_message.setText("Inserting instructor data");

        String firstName = instructor.getFirstName();
        String lastName = instructor.getLastName();

        String query =
            "INSERT INTO `collegedb`.`instructors` (`first_name`, `last_name`) VALUES ('" + firstName + "', '" +
            lastName + "');";
        Connection connection = getDBConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        // ResultSet resultSet = statement.executeQuery(query);

        jL_message.setText("Instructor added to database.");
    }

    /**
     *
     * @param jL_message update this label to inform the user on internal operations.
     * @return set of students
     * @throws SQLException
     */
    public static ResultSet getInstructors(JLabel jL_message) throws SQLException {
        jL_message.setText("Retrieving Instructors Data");

        Connection connection;
        connection = getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(DB.SELECT_INSTRUCTORS);

        jL_message.setText("Retrieved Instructors Data");
        return resultSet;
    }

    public static void removeInstructor(String id, JLabel jL_message) throws SQLException {
        jL_message.setText("Delteing instructor data");

        String query = "DELETE FROM `collegedb`.`instructors` WHERE `id`='" + id + "';";

        Connection connection = getDBConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        // ResultSet resultSet = statement.executeQuery(query);

        jL_message.setText("Instructor deleted from database.");
    } // end method removeInstructor
}
