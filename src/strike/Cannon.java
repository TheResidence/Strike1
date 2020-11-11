package strike;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cannon {

	public int x, y;
	public int width, height;

	public static Image image;

	static {
		try {
			image = ImageIO.read(new File("Images/Meteorit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Cannon(int x, int y, int width, int height, int velX, int velY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

}
