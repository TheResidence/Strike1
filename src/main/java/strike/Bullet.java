package strike;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author Shivam Sherma
 */
public class Bullet {
	public static ArrayList<Bullet> ammo = new ArrayList<>();
	public double x, y;
	public double width, height;
	public double velX, velY;
	public static final double WIDTH = 50;
	public static final double HEIGHT = 50;
	/**
	 * The image of the bullet is created
	 */
	public static BufferedImage originalImage;
	public BufferedImage image;

	static {
		try {
			originalImage = ImageIO.read(Bullet.class.getResource("/KiBlast.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param mouseX position of the Mouse
	 * @param mouseY position of the Mouse
	 * The Bullets are directly going to the Position where the Mouse klicks
	 */
	public static void spawnBullets(int mouseX, int mouseY) {
		double offX = (mouseX - WIDTH / 2) - (Strike.cannon.x + Strike.cannon.width / 2);
		double offY = (mouseY - HEIGHT / 2) - (Strike.cannon.y + Strike.cannon.height / 2);
		double dist = Math.sqrt(offX * offX + offY * offY);
		offX /= dist;
		offY /= dist;
		new Bullet(Strike.cannon.x + Strike.cannon.width / 2, Strike.cannon.y + Strike.cannon.height / 2, WIDTH, HEIGHT, offX * 20, offY * 20);
	}

	/**
	 * @param x      X position
	 * @param y      Y position
	 * @param width  Width of Bullet
	 * @param height Height of Bullet
	 * @param velX   Velocity of Bullet in X position
	 * @param velY   Velocity of Bullet in Y position
	 */
	Bullet(double x, double y, double width, double height, double velX, double velY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY = velY;
		image = Strike.resize(originalImage, 60, 60);
		image = Strike.rotate(image, Math.atan2(velY, velX) - Math.PI / 2D);
		ammo.add(this);
	}

	/**
	 * @param g2d Bullet Image
	 */
	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, (int) x, (int) y, null);
	}

	/**
	 * Here we loop backward trough the Meteorites
	 * if the Meteorites collide with the Bullet both will be removed
	 */
	public void update() {
		x += velX;
		y += velY;

		for (int i = Meteorit.meteorites.size() - 1; i >= 0; i--) {
			if (collidesWith(Meteorit.meteorites.get(i))) {
				Meteorit.meteorites.remove(i);
				Bullet.ammo.remove(this);
				Strike.score++;
			}
		}
	}

	/**
	 * @param meteorit the meteorit which will collide
	 * @return distance of the width of the Bullet/2 (Radius) + the width of the Meteorit/2 (Radius)
	 * Checks if the bullet and the Meterite collide by using pythagoras
	 */
	boolean collidesWith(Meteorit meteorit) {
		double offX = Math.abs(x - meteorit.x);
		double offY = Math.abs(y - meteorit.y);
		double dist = Math.sqrt(offX * offX + offY * offY);

		return (dist < this.width / 2 + meteorit.width / 2);
	}
}
