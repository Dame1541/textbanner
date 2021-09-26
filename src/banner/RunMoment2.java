package banner;

import javax.swing.JFrame;

public class RunMoment2 {


	public static void main(String[]args) {
		Viewer viewer = new Viewer();
		Controller controller = new Controller(viewer);
		Input input = new Input(controller);
		JFrame frameInput = new JFrame("Array7x7 input");
		JFrame frameViewer = new JFrame("Array7x7 viewer");
		frameInput.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frameInput.add( input );
		frameInput.pack();
		frameInput.setVisible( true );
		frameInput.setLocation(605, 0);
		frameViewer.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frameViewer.add( viewer );
		frameViewer.pack();
		frameViewer.setVisible( true );
	}


}
