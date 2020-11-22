package strike;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/***
 * @author Shivam Sherma
 * creates the Image of the Cannon
 */
public class Cannon {
    public double x, y;
    public double width, height;
    public static BufferedImage imageBlaster;
    static {
        try {
            imageBlaster = ImageIO.read(new File("Images/Falken.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /***
     * @param x position
     * @param y position
     * @param width of the Cannon
     * @param height of the Cannon
     */
    Cannon(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    /***
     * @param g2d is the image of the cannon which will be drawn
     */
    public void draw(Graphics2D g2d) {
        g2d.drawImage(imageBlaster, (int) x, (int) y, (int) width, (int) height, null);
    }
    public void update() {
    }
}
