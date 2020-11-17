package strike;

import java.util.TimerTask;
/***
 * @author Shivam Sherma
 */
public class DrawThread extends TimerTask {
	@Override
	public void run() {
		Strike.g.gamePanel.repaint();
	}
}
