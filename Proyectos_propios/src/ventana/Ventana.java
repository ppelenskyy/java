package ventana;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Ventana () {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void panel() {
		JPanel panel = new JPanel();
		panel.add(panel);
	}
	
}
