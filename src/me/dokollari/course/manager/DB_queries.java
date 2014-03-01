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


public class DB_queries {

  
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
    public final String DELETE_INSTRUCTOR = "DELETE FROM `collegedb`.`instructors` WHERE `id`='4';";
}
