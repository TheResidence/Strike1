package strike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Shivam Sherma
 */
public class GameWindow extends JFrame {
	GamePanel gamePanel;
	TimerTask drawThread = new DrawThread();
	TimerTask updateThread = new UpdateThread();

	/**
	 * adds the GamePanel
	 * activates the Mousehandler
	 * sets the Title and the Location of Strike
	 * creates a timer and Schedules the specified task for repeated fixed-rate execution,
	 * beginning after the specified delay.
	 * Subsequent executions take place at approximately regular intervals,
	 * separated by the specified period.
	 * In fixed-rate execution,
	 * each execution is scheduled relative to the scheduled execution time of the initial execution.
	 */
	public GameWindow() {
		gamePanel = new GamePanel();
		add(gamePanel);
		gamePanel.addMouseListener(new MouseHandler());
		setTitle("Strike");
		setLocation(10, 10);
		setResizable(true);
		setSize(800, 600);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		Timer t = new Timer();

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				Strike.cannon.x = gamePanel.getWidth() / 2d - 150;
				Strike.cannon.y = gamePanel.getHeight() - 400;
				Strike.screenSize = new Dimension(gamePanel.getWidth(), gamePanel.getHeight());
			}
		});

		t.scheduleAtFixedRate(drawThread, 0, 1000 / 60);
		t.scheduleAtFixedRate(updateThread, 0, 1000 / 60);
	}
}
