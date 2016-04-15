package net.dragberry.life.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import net.dragberry.life.engine.Environment;
import net.dragberry.life.engine.LiveEnvironment;

public class Application extends JFrame {

	private static final long serialVersionUID = -7531676006947803840L;
	
	private EnvironmentPanel envPanel;
	
	private RightPanel rightPanel;
	
	private Environment env = new LiveEnvironment();
	
	public void init() {
		setSize(1000, 800);
		setTitle("The Game of Live");
		JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPanel.setLeftComponent(getEnvPanel());
		splitPanel.setRightComponent(getRightPanel());
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(splitPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Application app = new Application();
			app.init();
		});
	}

	public EnvironmentPanel getEnvPanel() {
		if (envPanel == null) {
			envPanel = new EnvironmentPanel(env);
		}
		return envPanel;
	}

	public RightPanel getRightPanel() {
		if (rightPanel == null) {
			rightPanel = new RightPanel(env);
		}
		return rightPanel;
	}


}
