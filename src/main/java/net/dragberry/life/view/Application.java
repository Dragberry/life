package net.dragberry.life.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.dragberry.life.engine.Environment;
import net.dragberry.life.engine.LiveEnvironment;

public class Application extends JFrame {

	private static final long serialVersionUID = -7531676006947803840L;
	
	private EnvironmentPanel envPanel;
	
	private RightPanel rightPanel;
	
	private Environment env = new LiveEnvironment();
	
	public void init() {
		setSize(1200, 1000);
		setTitle("The Game of Live");
		getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		getContentPane().add(getEnvPanel(), gbc);
		
		gbc = new GridBagConstraints();
		
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		getContentPane().add(getRightPanel(), gbc);
		
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
