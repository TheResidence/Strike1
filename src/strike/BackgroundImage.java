package strike;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundImage {

	BufferedImage ibg;

	public BackgroundImage() {

		try {
			ibg = ImageIO.read(new File("Images/astro5.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
