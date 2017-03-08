package chess;

import javax.swing.*;

public class GUI {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		// create and set up the window
		JFrame frame = new JFrame("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add a label
		JLabel label = new JLabel("Chess");
		frame.getContentPane().add(label);

		// display the window
		frame.pack();
		frame.setVisible(true);
	}
}
