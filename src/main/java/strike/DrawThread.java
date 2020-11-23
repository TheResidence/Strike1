package strike;

import java.util.TimerTask;

/**
 * @author Shivam Sherma
 * Thread which draws the updated Objects in UpdateThread
 */
public class DrawThread extends TimerTask {
	@Override
	public void run() {
		Strike.window.gamePanel.repaint();
	}
}
