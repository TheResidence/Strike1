package strike;

import java.util.TimerTask;

public class DrawThread extends TimerTask {
	@Override
	public void run() {
		Strike.g.gamePanel.repaint();
	}
}
