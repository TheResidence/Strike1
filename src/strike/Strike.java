
package strike;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Shivam Sherma
 */
public class Strike {

	private Timer t;
	public static GameWindow g;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		g = new GameWindow();
		for (int i = 0; i < 10; i++)
			new Meteorit(Math.random() * g.getWidth(), 0, 200, 200, Math.random() * 3 - 1.5, Math.random() * 3);
	}

	public static void drawCenteredString(Graphics g, String text, Rectangle rect) {
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		g.drawString(text, x, y);
	}

	public static BufferedImage rotate(BufferedImage image, double angle) {
		AffineTransform tx = AffineTransform.getRotateInstance(angle, image.getWidth() / 2D, image.getHeight() / 2D);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op.filter(image, null);
	}
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}
}
