package net.dragberry.life.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.dragberry.life.engine.Environment;

public class RightPanel extends JPanel {

	private static final long serialVersionUID = -3125147945124778799L;
	
	private Environment enviroment;
	
	private JButton startButton;

	public RightPanel(Environment enviroment) {
		this.enviroment = enviroment;
		init();
	}
	
	private void init() {
		setSize(300, 100);
		add(getStartBtn());
		addListeners();
	}
	
	private void addListeners() {
		startButton.addActionListener(event -> {
			enviroment.switchState();
			startButton.setText(getStartButtonLbl(enviroment.isPaused()));
		});
	}

	private JButton getStartBtn() {
		if (startButton == null) {
			startButton = new JButton(getStartButtonLbl(enviroment.isPaused()));
		}
		return startButton;
	}
	
	private String getStartButtonLbl(boolean paused) {
		return paused ? "Start" : "Pause";
	}
}
