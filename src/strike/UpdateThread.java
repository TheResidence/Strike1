package strike;

import java.util.TimerTask;

public class UpdateThread extends TimerTask {
	@Override
	public void run() {
		for (int i = 0; i < Meteorit.meteorites.size(); i++) {
			Meteorit.meteorites.get(i).update();
		}
	}
}
