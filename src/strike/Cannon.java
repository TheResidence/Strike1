package strike;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/***
 * @author Shivam Sherma
 */
public class Cannon {

    public double x, y;
    public double width, height;

    public static BufferedImage imageBlaster;
    public static BufferedImage imageFalk;

    static {
        try {
            imageFalk = ImageIO.read(new File("Images/Falk.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            imageBlaster = ImageIO.read(new File("Images/Falken.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /***
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    Cannon(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    /***
     *
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        g2d.drawImage(imageFalk, (int) x, (int) y, (int) width, (int) height, null);
        g2d.drawImage(imageBlaster, (int) x, (int) y, (int) width, (int) height, null);
    }

    public void update() {
    }
}
