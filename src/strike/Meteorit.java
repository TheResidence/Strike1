package strike;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Meteorit {

	public static ArrayList<Meteorit> meteorites = new ArrayList<Meteorit>();

	public int x, y;
	public int width, height;
	public int velX, velY;

	public static Image image;
	static {
		try {
			image = ImageIO.read(new File("Images/Meteorit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Meteorit(int x, int y, int width, int height, int velX, int velY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY = velY;

		meteorites.add(this);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, x, y, width, height, null);
	}

	public void update() {
		x += velX;
		y += velY;
	}
}
