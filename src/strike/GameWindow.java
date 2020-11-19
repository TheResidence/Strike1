package strike;

import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;
/***
 * @author Shivam Sherma
 */
public class GameWindow extends JFrame {
	GamePanel gamePanel;
	TimerTask drawThread = new DrawThread();
	TimerTask updateThread = new UpdateThread();

	public GameWindow() {
		gamePanel = new GamePanel();
		add(gamePanel);
		gamePanel.addMouseListener(new MouseHandler());
		setTitle("Strike");
		setLocation(10, 10);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		Timer t = new Timer();
		t.scheduleAtFixedRate(drawThread, 0, 1000 / 60);
		t.scheduleAtFixedRate(updateThread, 0, 1000 / 60);
	}
}
