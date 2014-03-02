package me.dokollari.cmanager.video;

import static com.googlecode.javacv.cpp.opencv_core.cvFlip;

import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class GrabberShow implements Runnable
{
	// final int INTERVAL=1000;///you may use interval
	IplImage image;
	CanvasFrame canvas = new CanvasFrame("Web Cam");

	public GrabberShow() {
		canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
		int i = 0;
		try {
			grabber.start();
			IplImage img;
			while (true) {
				img = grabber.grab();
				if (img != null) {
					cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise
					cvSaveImage("lib/img/pic/" + (i++) + "-aa.jpg", img);
					// show image on window
					canvas.showImage(img);
				}
				// Thread.sleep(INTERVAL);
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		GrabberShow gs = new GrabberShow();
		Thread th = new Thread(gs);
		th.start();
	}
}