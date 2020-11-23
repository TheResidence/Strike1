package strike;

import java.nio.channels.SelectionKey;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.TimerTask;

/**
 * @author Shivam Sherma
 * Thread which Updates the meteorites and the bullets
 */
public class UpdateThread extends TimerTask {
	public static int spawnMeteorit = 0;

	@Override
	public void run() {
		if (Strike.dead) return;
		spawnMeteorit++;

		if (spawnMeteorit >= 50) {
			new Meteorit(Math.random() * (Strike.screenSize.getWidth() - 200), -200, 200, 200, (Math.random() - 0.5) * 2, Math.random() * 2 + 2);
			spawnMeteorit = 0;
		}

		Strike.cannon.update();
		for (int i = 0; i < Meteorit.meteorites.size(); i++) {
			Meteorit.meteorites.get(i).update();
			if (Meteorit.meteorites.get(i).getY() > Strike.screenSize.getHeight()) {
				Strike.dead = true;
			}
		}
		for (int j = 0; j < Bullet.ammo.size(); j++) {
			Bullet.ammo.get(j).update();
		}
	}
}
