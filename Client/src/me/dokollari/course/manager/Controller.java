package me.dokollari.course.manager;

import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
} // end method setJLabelImage
