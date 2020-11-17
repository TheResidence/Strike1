package strike;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/***
 * @author Shivam Sherma
 */
public class GamePanel extends JPanel {

	public static BufferedImage i;

	static {
		try {
			i = ImageIO.read(new File("Images/astro5.jpeg"));
		} catch (Exception e) {
			System.out.println("error");
		}
	}

	/***
	 *
	 * @param g
	 */
	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Background
		g2d.drawImage(i, 0, 0, Strike.screenSize.width, Strike.screenSize.height, null);

		for (int i = 0; i < Meteorit.meteorites.size(); i++) {
			Meteorit.meteorites.get(i).draw(g2d);
		}
		for (int i = 0; i < Bullet.ammo.size(); i++) {
			Bullet.ammo.get(i).draw(g2d);
		}
		Strike.cannon.draw(g2d);
	}
}