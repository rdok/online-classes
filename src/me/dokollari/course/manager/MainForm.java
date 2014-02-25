
package me.dokollari.course.manager;

import me.dokollari.course.manager.swings.JD_EditClasses;
import me.dokollari.course.manager.swings.JD_EditData;


/**
 *
 * @author Rizart Dokollari
 */
public class MainForm extends java.awt.Frame {

    private static final String APP_TITLE = "E-learning Managment System";
    private Controller controller;

    /** Creates new form MainForm */
    public MainForm() {
        initComponents();
        initFinalCompon();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        jP_top_parent = new javax.swing.JPanel();
        jB_editClassData = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jB_editInternalData = new javax.swing.JButton();
        jP_background_holder = new javax.swing.JPanel();
        jL_img_holder = new javax.swing.JLabel();
        jB_quit = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jP_top_parent.setBackground(new java.awt.Color(102, 204, 255));

        jB_editClassData.setBackground(new java.awt.Color(51, 153, 255));
        jB_editClassData.setText("Edit Class Data");
        jB_editClassData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_editClassDataActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setText("Classes Data");

        jB_editInternalData.setBackground(new java.awt.Color(102, 153, 255));
        jB_editInternalData.setText("Edit Internal Data");
        jB_editInternalData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_editInternalDataActionPerformed(evt);
            }
        });

        jP_background_holder.setLayout(new AbsoluteLayout());
        jP_background_holder.add(jL_img_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 361, 161));

        jB_quit.setBackground(new java.awt.Color(51, 153, 255));
        jB_quit.setText("Quit");
        jB_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_quitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_top_parentLayout = new javax.swing.GroupLayout(jP_top_parent);
        jP_top_parent.setLayout(jP_top_parentLayout);
        jP_top_parentLayout.setHorizontalGroup(
            jP_top_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_top_parentLayout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jB_quit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jP_top_parentLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jP_top_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jB_editClassData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jP_background_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jB_editInternalData)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jP_top_parentLayout.setVerticalGroup(
            jP_top_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_top_parentLayout.createSequentialGroup()
                .addGroup(jP_top_parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_top_parentLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jB_editClassData)
                        .addGap(36, 36, 36)
                        .addComponent(jButton2))
                    .addGroup(jP_top_parentLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jP_background_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_top_parentLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jB_editInternalData)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jB_quit)
                .addGap(26, 26, 26))
        );

        add(jP_top_parent, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    
    private void initFinalCompon() {
        // swings
        // resizing jlabel requires it's width & height which are applied after the frame is set to visible
        Controller.setJLabelImage(jL_img_holder, Images.IMG_MAIN_BANNER);
        // set app to start from center
        this.setLocationRelativeTo(null);
        this.setTitle(APP_TITLE);

        // data
        controller = new Controller();
    }

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void jB_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_quitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jB_quitActionPerformed

    private void jB_editClassDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editClassDataActionPerformed
        //new JD_EditClasses(this, true, controller);
    }//GEN-LAST:event_jB_editClassDataActionPerformed

    private void jB_editInternalDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editInternalDataActionPerformed
        new JD_EditData(this, true, controller);
    }//GEN-LAST:event_jB_editInternalDataActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_editClassData;
    private javax.swing.JButton jB_editInternalData;
    private javax.swing.JButton jB_quit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jL_img_holder;
    private javax.swing.JPanel jP_background_holder;
    private javax.swing.JPanel jP_top_parent;
    // End of variables declaration//GEN-END:variables

}
