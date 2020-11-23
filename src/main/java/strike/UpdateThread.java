package strike;

import java.util.TimerTask;

/**
 * @author Shivam Sherma
 *
 */
public class UpdateThread extends TimerTask {
	public static int spawnMeteorit = 0;

	/**
	 * The meteorites spawn
	 * The Bullets spawn
	 * If you loose the Meteorites will return to 0 and spawn again
	 */
	@Override
	public void run() {
		if (Strike.dead) return;
		spawnMeteorit++;

		if (spawnMeteorit >= 25) {
			new Meteorit(Math.random() * (Strike.screenSize.getWidth() - 200), -200, 200, 200, (Math.random() - 0.5) * 2, Math.random() * 2 + 4);
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
