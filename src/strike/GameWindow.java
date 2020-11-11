
package strike;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

	public final GamePanel StrikeGamePanel;

	Draw d;

	public GameWindow() {

		this.StrikeGamePanel = new GamePanel();

		registerWindowListener();
		createMenu();

		add(StrikeGamePanel);
		pack();

		d = new Draw();

		setTitle("Strike");
		setLocation(10, 10);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		// setSize(800,600);

		setVisible(true);

	}

	private void registerWindowListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				StrikeGamePanel.pauseGame();
			}

			@Override
			public void windowActivated(WindowEvent e) {
				StrikeGamePanel.continueGame();
			}
		});
	}

	private void createMenu() {

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		JMenu gameMenu = new JMenu("Game");

		menuBar.add(fileMenu);
		menuBar.add(gameMenu);

		addFileMenuItems(fileMenu);
		addGameMenuItems(gameMenu);
	}

	private void addFileMenuItems(JMenu fileMenu) {

		JMenuItem quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		quitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void addGameMenuItems(JMenu gameMenu) {
		JMenuItem pauseItem = new JMenuItem("Pause");
		gameMenu.add(pauseItem);
		pauseItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StrikeGamePanel.pauseGame();
			}
		});

		JMenuItem continuetItem = new JMenuItem("Continue");
		gameMenu.add(continuetItem);
		continuetItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StrikeGamePanel.continueGame();
			}
		});

		gameMenu.addSeparator();
		JMenuItem restartItem = new JMenuItem("Restart");
		gameMenu.add(restartItem);
		restartItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StrikeGamePanel.restartGame();
			}
		});
	}

}
