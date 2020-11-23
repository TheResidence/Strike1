package strike;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Shivam Sherma
 * creates the Background image of Strike
 */
public class GamePanel extends JPanel {
	public static BufferedImage background;
	public static BufferedImage gameOver;

	static {
		try {
			background = ImageIO.read(GamePanel.class.getResource("/astro5.jpeg"));
			gameOver = ImageIO.read(GamePanel.class.getResource("/GameOver.png"));
		} catch (Exception e) {
			System.out.println("error");
		}
	}

	/**
	 * sets the graphic component of the Background
	 * First it creates the meteorites
	 * Second it creates the Bullets
	 * Third the Cannon
	 * Fourth the Collision Counter
	 *
	 * @param image the image of the background
	 */
	@Override
	protected void paintComponent(Graphics image) {
		Graphics2D g2d = (Graphics2D) image;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Background
		g2d.drawImage(background, 0, 0, Strike.screenSize.width, Strike.screenSize.height, null);

		for (int i = 0; i < Meteorit.meteorites.size(); i++) {
			Meteorit.meteorites.get(i).draw(g2d);
		}
		for (int i = 0; i < Bullet.ammo.size(); i++) {
			Bullet.ammo.get(i).draw(g2d);
		}
		Strike.cannon.draw(g2d);
		String score = Strike.score + "";
		g2d.setColor(Color.RED);
		Font currentFont = getFont();
		g2d.setFont(getFont().deriveFont(currentFont.getSize() * 3F));
		g2d.drawString(score, getWidth() / 2 - getFontMetrics(g2d.getFont()).stringWidth(score) / 2, getHeight() - 50);
		g2d.setFont(currentFont);

		if (Strike.dead) {
			g2d.drawImage(gameOver, 0, 0, Strike.screenSize.width, Strike.screenSize.height, null);
		}
	}
}