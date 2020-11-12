
package strike;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

public class GameWindow extends JFrame {
	GamePanel gamePanel;

	TimerTask drawThread = new DrawThread();
	TimerTask updateThread = new UpdateThread();

	public GameWindow() {
		pack();

		gamePanel = new GamePanel();
		add(gamePanel);

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
