package strike;

import java.util.TimerTask;
/***
 * @author Shivam Sherma
 * Thread which Updates the meteorites and the bullets
 */
public class UpdateThread extends TimerTask {
	@Override
	public void run() {
		Strike.cannon.update();
		for (int i = 0; i < Meteorit.meteorites.size(); i++) {
			Meteorit.meteorites.get(i).update();
			}
		for (int j = 0; j < Bullet.ammo.size(); j++) {
			Bullet.ammo.get(j).update();
		}
	}
}
