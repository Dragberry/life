package net.dragberry.life.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import net.dragberry.life.engine.Environment;
import net.dragberry.life.engine.LiveEnvironment;

public class Application extends JFrame {

	private static final long serialVersionUID = -7531676006947803840L;
	
	private Environment enviroment = new LiveEnvironment();
	
	public void init() {
		setMinimumSize(new Dimension(enviroment.xUpperBorder() * enviroment.getScale(), enviroment.yUpperBorder() * enviroment.getScale()));
		setTitle("The Game of Live");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		int counter = 0;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(++counter);
			enviroment.live();
			repaint();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		enviroment.paint(g);
	}

}
