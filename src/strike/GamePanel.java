package strike;

/**
 *
 * @author Shivam Sherma
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
			
	private boolean gameOver = false;
	private int PunkteCounter = 0;

	private Timer t;

	public static BufferedImage i;

	static {

		try {

			i = ImageIO.read(new File("Images/astro5.jpeg"));

		} catch (Exception e) {

		}

	}

	private final Dimension prefSize = new Dimension(1180, 700);

	public GamePanel() {
		setFocusable(true);
		setPreferredSize(prefSize);

		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawThread();
			}
		});
		
		startGame();
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}		
	
	

	private void startGame() {
		t.start();
	}

	public void pauseGame() {
		t.stop();
	}

	public void continueGame() {
		if (!isGameOver())
			t.start();
	}

	public void restartGame() {
		PunkteCounter = 0;
		setGameOver(false);
		startGame();
	}

	private void endGame() {
		setGameOver(true);
		pauseGame();
	}

	private void DrawThread() {
		PunkteCounter++;
		if (PunkteCounter > 59)
			endGame();

		repaint();
	}
	
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = Strike.g.StrikeGamePanel.getSize().width;

		int h = Strike.g.StrikeGamePanel.getSize().height;

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.drawImage(i, 0, 0, w, h, null);

		g2d.setColor(new Color(0, 0, 0, 110));

		g2d.fill(getBounds());

		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		g.setColor(Color.WHITE);
		drawCenteredString(g, "Punkte:" + PunkteCounter, new Rectangle(0, h - 30, w, 0),
				new Font(Font.MONOSPACED, Font.BOLD, 20));

		if (isGameOver()) {
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
			g.setColor(Color.WHITE);
			drawCenteredString(g, "Strike!", new Rectangle(0, 100, w, 0), new Font(Font.MONOSPACED, Font.BOLD, 50));
		}
		

	}

	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as in java
		// 2d 0 is top of the screen)
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		// Set the font
		g.setFont(font);
		// Draw the String
		g.drawString(text, x, y);
	}
	
	
	
	

}
