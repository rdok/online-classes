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

import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import me.dokollari.course.manager.models.Instructor;

/**
 * @author Rizart Dokollari
 *
 */
public class Controller {
    List<Instructor> instructors;

    public Controller() {
        instructors = new ArrayList<Instructor>();
    }

    /**
     * sets the background image for a jlabel.
     * @param jL_img_holder
     * @param filePath
     */
    static public void setJLabelImage(JLabel jL_img_holder, String filePath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image fin_img = img.getScaledInstance(jL_img_holder.getWidth(), jL_img_holder.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(fin_img);
        jL_img_holder.setIcon(imageIcon);
    } // end method setJLabelImage

    public void addInstructor(String lastName, String firstName, JLabel jL_message) throws Exception {
        Instructor instructor = new Instructor(lastName, firstName);
        DB.insertInstructor(instructor, jL_message);
    }

    public static String getInstructors(JLabel jL_message) throws SQLException, Exception {
        ResultSet resultSet = DB.getInstructors(jL_message);

        List<Instructor> instructors = new ArrayList<Instructor>();
        Instructor instructor;

        while (resultSet.next()) {
            int id = resultSet.getInt(DB.ID);
            String firstName = resultSet.getString(DB.FIRST_NAME);
            String lastName = resultSet.getString(DB.LAST_NAME);
            instructor = new Instructor(lastName, firstName, id);

            instructors.add(instructor);
        }
        String output = Viewer.format(instructors);

        return output;
    }

    public void removeInstructor(JTextField jTF_instructorsID, JLabel jL_dbMessages) throws SQLException {
            DB.removeInstructor(jTF_instructorsID.getText(), jL_dbMessages);
    }
} // end method setJLabelImage
