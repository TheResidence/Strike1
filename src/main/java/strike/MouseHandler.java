package strike;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.OffsetDateTime;

/**
 * @author Shivam Sherma
 * if Button 1 of the Mouse is pressed the Bullets will spawn
 * After loosing the Game the full Game Resets
 *
 */
public class MouseHandler implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!Strike.dead && e.getButton() == MouseEvent.BUTTON1) {
			Bullet.spawnBullets(e.getX(), e.getY());
		}
		if (Strike.dead && e.getButton() == MouseEvent.BUTTON1) {
			Meteorit.meteorites.clear();
			Bullet.ammo.clear();
			Strike.start = OffsetDateTime.now();
			Strike.dead = false;
			Strike.score = 0;
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
