package strike;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Draw extends JPanel {
	public static BufferedImage image;
	static {
		try {
			image = ImageIO.read(new File("Images/astro5.jpeg"));
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, null);
	}
}