package es.unileon.aw.GUI.contractForm;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Class which represents a panel where an image is drawn
 * 
 * @author Emanuel Iosif Relea
 * @version 2.5
 */

@SuppressWarnings("serial")
public class JPicture extends JPanel{
	
	BufferedImage image;

	/**
	 * Constructor method. Reads an image from a file and assigns it to a 
	 * BufferedImage object.
	 * 
	 */
	
    public JPicture(String imagePath) {
       try {                
          image = ImageIO.read(new File(imagePath));
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    }

    /**
     * Draws the image in the panel
     */
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

}
