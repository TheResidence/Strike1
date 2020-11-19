package strike;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundImage {
	BufferedImage image;
	public BackgroundImage() {
		try {
			image = ImageIO.read(new File("Images/astro5.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
