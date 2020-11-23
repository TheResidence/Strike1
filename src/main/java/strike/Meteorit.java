package strike;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author Shivam Sherma
 */
public class Meteorit {
	public static ArrayList<Meteorit> meteorites = new ArrayList<>();
	public double x, y;
	public double width, height;
	public double velX, velY;
	public static BufferedImage originalImage;
	public BufferedImage image;

	/**
	 * creates the Image for the Meteorit
	 */
	static {
		try {
			originalImage = ImageIO.read(Meteorit.class.getResource("/Meteorit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param x      position
	 * @param y      position
	 * @param width  of the meteorites
	 * @param height of the meteorites
	 * @param velX   of the meteorites in X way
	 * @param velY   of the meteorites in Y way
	 */
	Meteorit(double x, double y, double width, double height, double velX, double velY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY = velY;
		image = Strike.resize(originalImage, 150, 150);
		image = Strike.rotate(image, Math.atan2(velY, velX) - Math.PI / 2D);
		meteorites.add(this);
	}

	/**
	 * @param g2d the Image of the Meteorites which will be drawn
	 *            updates the velocity in X,Y way
	 *            X,Y position + velX/velY
	 */
	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, (int) x, (int) y, null);
	}

	public void update() {
		x += velX;
		y += velY;
		x = Math.max(Math.min(Strike.screenSize.getWidth() - width, x), 0);
		//y = Math.max(Math.min(Strike.screenSize.getHeight() - height, y), -200);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
