package me.dokollari.cmanager.video;

import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import javax.swing.ImageIcon;

/**
 * Tests image capturing; pastes captured image to jframe.
 * 
 * @author Rizart Dokollari
 * @since Mar 1, 2014
 */
public class ImageCaptureFrame
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try {
					ImageCaptureFrame window = new ImageCaptureFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ImageCaptureFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel backGroundPanel = new JPanel();
		backGroundPanel.setBackground(new Color(0, 204, 102));
		backGroundPanel.setBounds(0, 0, 719, 299);
		frame.getContentPane().add(backGroundPanel);
		backGroundPanel.setLayout(null);

		final JLabel lblCapturedImg = new JLabel("");
		lblCapturedImg.setIcon(new ImageIcon(ImageCaptureFrame.class.getResource("/img/elearing_banner.jpg")));
		lblCapturedImg.setBounds(179, 11, 530, 277);
		backGroundPanel.add(lblCapturedImg);
		lblCapturedImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapturedImg.setBackground(Color.GRAY);
		
		JButton btnCaptureImage = new JButton("Capture Image");
		btnCaptureImage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				captureFrame();
			}

			private void captureFrame() {
				// 0-default camera, 1 - next...so on
				OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
				try {
					grabber.start();
					IplImage img = grabber.grab();
					if (img != null) {

						cvSaveImage("lib/img/capture.jpg", img);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				lblCapturedImg.setIcon(new ImageIcon(ImageCaptureFrame.class.getResource("lib/img/capture.jpg")));

			}
		});
		btnCaptureImage.setBounds(10, 27, 132, 23);
		backGroundPanel.add(btnCaptureImage);

	
	}
}
