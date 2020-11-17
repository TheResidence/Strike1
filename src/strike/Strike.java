
package strike;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/***
 * @author Shivam Sherma
 */
public class Strike {

	public static Dimension screenSize;
	private Timer t;
	public static GameWindow g;
	public static Cannon cannon;
	/***
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cannon = new Cannon(screenSize.width/2d-150, screenSize.height-400, 300, 300);
		g = new GameWindow();
		for (int i = 0; i < 100; i++)
			new Meteorit(Math.random() * g.getWidth(), -400, 200, 200, Math.random() * 3 - 1.5, Math.random() * 3);
	}
	/***
	 *
	 * @param g
	 * @param text
	 * @param rect
	 */
	public static void drawCenteredString(Graphics g, String text, Rectangle rect) {
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		g.drawString(text, x, y);
	}

	/***
	 *
	 * @param image
	 * @param angle
	 * @return
	 */
	public static BufferedImage rotate(BufferedImage image, double angle) {
		AffineTransform tx = AffineTransform.getRotateInstance(angle, image.getWidth() / 2D, image.getHeight() / 2D);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op.filter(image, null);
	}

	/***
	 *
	 * @param img
	 * @param newW
	 * @param newH
	 * @return
	 */
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}
}
