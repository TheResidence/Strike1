package strike;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/***
 * @author Shivam Sherma
 */
public class Strike {

    public static Dimension screenSize;
    public static GameWindow window;
    public static Cannon cannon;

    /***
     *
     * @param args the command line arguments
     * create the screen
     * create the cannon
     * create the meteorites
     */
    public static void main(String[] args) {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        cannon = new Cannon(screenSize.width / 2d - 150, screenSize.height - 400, 300, 300);
        window = new GameWindow();
        for (int i = 0; i < 99; i++)
            new Meteorit(Math.random() * window.getWidth(), -400, 200, 200, Math.random() * 3 - 1.5, Math.random() * 3);
        collision();
    }

    /***
     *
     * @param image Meteorites
     * @param angle Meteorites angle
     * @return bufferedImage
     */
    public static BufferedImage rotate(BufferedImage image, double angle) {
        AffineTransform tx = AffineTransform.getRotateInstance(angle, image.getWidth() / 2D, image.getHeight() / 2D);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(image, null);
    }

    /***
     *
     * @param img Image
     * @param newW new width
     * @param newH new height
     * @return Image
     */
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dig = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dig.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dig;
    }

}
