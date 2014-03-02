package me.dokollari.cmanager.video;

import com.googlecode.javacv.OpenCVFrameGrabber;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

public class Test
{

	private void captureFrame() {
		// 0-default camera, 1 - next...so on
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		try {
			grabber.start();
			IplImage img = grabber.grab();
			if (img != null) {
				cvSaveImage("capture.jpg", img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Test();
	}

	public Test() {
		captureFrame();
	}
}
