package banner;

import javax.swing.JFrame;

public class RunMoment4 {
	
	public static void main(String[] args) {
		MainController mc = new MainController();
		Display display = new Display(mc);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(display);
		frame.pack();
		frame.setVisible(true);
	}
}
