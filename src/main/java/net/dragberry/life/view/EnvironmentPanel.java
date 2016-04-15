package net.dragberry.life.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import net.dragberry.life.engine.Environment;

public class EnvironmentPanel extends JPanel {

	private static final long serialVersionUID = 7192425716315027773L;
	
	private Environment enviroment;
	
	public EnvironmentPanel(Environment enviroment) {
		this.enviroment = enviroment;
		init();
		start();
	}

	private void start() {
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!enviroment.isPaused()) {
					enviroment.live();
					repaint();
				}
			}
		}).start();
		
	}

	private void init() {
//		setSize(enviroment.xUpperBorder() * enviroment.getScale(), enviroment.yUpperBorder() * enviroment.getScale());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		enviroment.paint(g);
	}
}
