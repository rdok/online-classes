package me.dokollari.course.manager;


public class DB_queries {

    public static final String SELECT_STUDENTS = "SELECT * FROM collegedb.students;";
    public static final String STUDENT_ID = "id";
    public static final String STUDENT_LAST_NAME = "last_name";
    public static final String STUDENT_FIRST_NAME = "first_name";

    public final String INSERT_CLASS =
        "INSERT INTO `collegedb`.`classes` (`name`, `courses_id`, `instructors_id`, `max_students`) VALUES ('102', '1', '1', '14');";
    public final String INSERT_COURSE =
        "INSERT INTO `collegedb`.`courses` (`title`, `level`) VALUES ('ITC3416 Software Engineering', '6');";
    public final String INSERT_DATE =
        "INSERT INTO `collegedb`.`date` (`date`, `time_start`, `time_end`) VALUES ('2014-01-01', '09:00', '09:50');";
    public final String INSERT_INSTRUCTOR =
        "INSERT INTO `collegedb`.`instructors` (`first_name`, `last_name`) VALUES ('Wolfgang', 'Ketterle');";
    public final String INSERT_ROOM = "INSERT INTO `collegedb`.`rooms` (`name`) VALUES ('101');";
    public final String INSERT_STUDENT =
        "INSERT INTO `collegedb`.`students` (`last_name`, `first_name`, `advisor_id`) VALUES ('Aijazi', 'Arfa', '1');";
    public final String INSERT_DATE_CLASS =
        "INSERT INTO `collegedb`.`date_class` (`date_id`, `classes_id`) VALUES ('1', '2');";
    public final String INSERT_INSTRUCTOR_COURSE =
        "INSERT INTO `collegedb`.`instructors_courses` (`instructors_id`, `courses_id`) VALUES ('1', '2');";
    public final String INSERT_STUDENT_CLASS =
        "INSERT INTO `collegedb`.`students_classes` (`students_id`, `classes_id`) VALUES ('1', '1');";
    public final String INSERT_STUDENT_COURSE =
        "INSERT INTO `collegedb`.`students_courses` (`students_id`, `courses_id`) VALUES ('1', '1');";
}
