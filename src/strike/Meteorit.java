package strike;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Meteorit {

	public static ArrayList<Meteorit> meteorites = new ArrayList<Meteorit>();

	public double x, y;
	public double width, height;
	public double velX, velY;

	public static BufferedImage originalImage;
	public BufferedImage image;

	static {
		try {
			originalImage = ImageIO.read(new File("Images/Meteorit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Meteorit(double x, double y, double width, double height, double velX, double velY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY = velY;

		image = Strike.resize(originalImage, 100, 100);
		image = Strike.rotate(image, Math.atan2(velY, velX) - Math.PI / 2D);

		meteorites.add(this);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, (int) x, (int) y, null);
	}

	public void update() {
		x += velX;
		y += velY;
	}
}
