package strike;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/***
 * @author Shivam Sherma
 * if Button 1 of the Mouse is pressed the Bullets will spawn
 */
public class MouseHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1) {
            Bullet.spawnBullets(e.getX(), e.getY());
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
