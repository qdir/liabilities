package es.unileon.ulebank.GUI.tools;

import es.unileon.ulebank.GUI.contractForm.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class which represents a panel where the user can draw with his cursor
 * @author Emanuel Iosif Relea
 */
@SuppressWarnings("serial")
public class JDrawable extends JPanel {

	/**
	 * Image used to draw over.
	 */
	protected Image inputImage;

	/**
	 * The graphics handler
	 */
	protected Graphics inputGraphics;

	/**
	 * The last X coordinate where the user has drawn
	 */
	protected int lastX = -1;

	/**
	 * The last Y coordinate where the user has drawn
	 */
	protected int lastY = -1;

	/**
	 * Specifies the left bound of the image
	 */
	protected int leftBoundImage;

	/**
	 * Specifies the right bound of the image
	 */
	protected int rightBoundImage;

	/**
	 * Specifies the upper bound of the image
	 */
	protected int upperBoundImage;

	/**
	 * Specifies the lower bound of the image
	 */
	protected int lowerBoundImage;

	/**
	 * Crop proportion for X coordinate
	 */
	protected double proportionX;

	/**
	 * Crop proportion for Y coordinate
	 */
	protected double proportionY;

	/**
	 * The pixel map which represents the users drawing
	 */
	protected int pixelMap[];

	/**
	 * Class constructor. Sets all the necessary listeners.
	 */
	public JDrawable() {

		enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK
				| AWTEvent.MOUSE_EVENT_MASK | AWTEvent.COMPONENT_EVENT_MASK);

	}

	/**
	 * Configures the internal image the user will draw
	 */
	protected void imageConfig() {

		inputImage = createImage(getWidth(), getHeight());
		inputGraphics = inputImage.getGraphics();
		inputGraphics.setColor(Color.white);
		inputGraphics.fillRect(0, 0, getWidth(), getHeight());

	}

	/**
	 * Draws the image
	 * 
	 */
	public void paint(Graphics graficos) {

		if (inputImage == null)
			imageConfig();

		graficos.drawImage(inputImage, 0, 0, this);
		graficos.setColor(Color.black);
		graficos.drawRect(0, 0, getWidth(), getHeight());
		graficos.setColor(Color.red);
		graficos.drawRect(leftBoundImage, upperBoundImage,
				rightBoundImage - leftBoundImage,
				lowerBoundImage - upperBoundImage);

	}

	/**
	 * Processes events related to the mouse
	 * 
	 */
	protected void processMouseEvent(MouseEvent event) {

		if (event.getID() != MouseEvent.MOUSE_PRESSED)
			return;
		lastX = event.getX();
		lastY = event.getY();

	}

	/**
	 * Processes events related to mouse movements
	 * 
	 */
	protected void processMouseMotionEvent(MouseEvent event) {

		if (event.getID() != MouseEvent.MOUSE_DRAGGED)
			return;

		inputGraphics.setColor(Color.BLUE);
		inputGraphics
				.drawLine(lastX, lastY, event.getX(), event.getY());
		getGraphics().drawImage(inputImage, 0, 0, this);

		lastX = event.getX();
		lastY = event.getY();

	}

	/**
	 * Scans the Y coordinate line and checks whether pixels were filled along the line
	 * 
	 */
	protected boolean scanPixelsY(int y) {

		int width = inputImage.getWidth(this);

		for (int i = 0; i < width; i++) {
			if (pixelMap[(y * width) + i] != -1)
				return false;
		}

		return true;

	}

	/**
	 * Scans the X coordinate line and checks whether pixels were filled along the line
	 */
	protected boolean scanPixelsX(int x) {

		int width = inputImage.getWidth(this);
		int height = inputImage.getHeight(this);

		for (int i = 0; i < height; i++) {
			if (pixelMap[(i * width) + x] != -1)
				return false;
		}

		return true;

	}

	/**
	 * This method scans the image and removes additional white space
	 */
	protected void scanBorders(int width, int height) {

		
		for (int y = 0; y < height; y++) {
			if (!scanPixelsY(y)) {
				upperBoundImage = y;
				break;
			}

		}

		
		for (int y = height - 1; y >= 0; y--) {
			if (!scanPixelsY(y)) {
				lowerBoundImage = y;
				break;
			}
		}

		
		for (int x = 0; x < width; x++) {
			if (!scanPixelsX(x)) {
				leftBoundImage = x;
				break;
			}
		}

		
		for (int x = width - 1; x >= 0; x--) {
			if (!scanPixelsX(x)) {
				rightBoundImage = x;
				break;
			}
		}
	}

	/**
	 * Crops a rectangle from the image
	 */
	protected boolean cropRectangle(int x, int y) {

		int width = inputImage.getWidth(this);
		int startX = (int) (leftBoundImage + (x * proportionX));
		int startY = (int) (upperBoundImage + (y * proportionY));
		int endX = (int) (startX + proportionX);
		int endY = (int) (startY + proportionY);

		for (int yy = startY; yy <= endY; yy++) {
			for (int xx = startX; xx <= endX; xx++) {
				int index = xx + (yy * width);

				if (pixelMap[index] != -1)
					return true;
			}
		}

		return false;

	}


	/**
	 * Clears the pixels in the image
	 */
	public void clearImage() {

		this.inputGraphics.setColor(Color.white);
		this.inputGraphics.fillRect(0, 0, getWidth(), getHeight());
		this.lowerBoundImage = this.upperBoundImage = this.leftBoundImage = this.rightBoundImage = 0;
		repaint();

	}
}