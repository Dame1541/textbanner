package banner;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

/**
 * En klass för att skapa en display utav 7x10 Array7x7 objekt. Displayen innehåller ett antal knappar
 * samt en färgfylld display med dynamisk text och/eller med bilder.
 * 
 * @author Iris Brinkborg
 * @author Amanda Eriksson
 */
public class Display extends JPanel {
	private Timer timer;
	private boolean scrolling;

	private JPanel pnlColorPanel = new JPanel(new BorderLayout());
	private JPanel pnlArrows = new JPanel(new GridLayout(3, 3));
	private JPanel pnlSouth = new JPanel(new GridLayout(1, 3));

	private JButton btnUpLeft = new JButton("Diagonal");
	private JButton btnUp = new JButton("Up");
	private JButton btnUpRight = new JButton("Diagonal");
	private JButton btnLeft = new JButton("Left");
	private JButton btnCenter = new JButton("Stop");
	private JButton btnRight = new JButton("Right");
	private JButton btnDownLeft = new JButton("Diagonal");
	private JButton btnDown = new JButton("Down");
	private JButton btnDownRight = new JButton("Diagonal");

	private JFileChooser fileChooser = new JFileChooser();

	// Knappar för att sätta text och bild
	private JButton btnSetText = new JButton("Choose a text"); 
	private JButton btnBigRight = new JButton("Choose a picture");

	private MainController mc;
	private ColorDisplay cd = new ColorDisplay(7, 10, Color.WHITE, Color.BLACK, 1, 10);
	
	/**
	 * Konstruerar och initierar knappar samt storlek på displayen
	 * 
	 * @param mc Det maincontroller objekt som vi använder
	 */

	public Display(MainController mc) {
		this.mc = mc;
		scrolling = false;
		mc.setDisplaySize(7, 10);
		mc.fillArrayRandom();
		mc.finalizeDisplayArray();

		setPreferredSize(new Dimension(755, 630));
		setLayout(new BorderLayout());

		pnlArrows.add(btnUpLeft);
		pnlArrows.add(btnUp);
		pnlArrows.add(btnUpRight);
		pnlArrows.add(btnLeft);
		pnlArrows.add(btnCenter);
		pnlArrows.add(btnRight);
		pnlArrows.add(btnDownLeft);
		pnlArrows.add(btnDown);
		pnlArrows.add(btnDownRight);

		pnlSouth.add(btnSetText);
		pnlSouth.add(pnlArrows);
		pnlSouth.add(btnBigRight);

		pnlColorPanel.add(cd);

		add(pnlColorPanel, BorderLayout.NORTH);
		add(pnlSouth, BorderLayout.SOUTH);

		ScrollerListener listener = new ScrollerListener();

		btnUpLeft.addActionListener(listener);
		btnUp.addActionListener(listener);
		btnUpRight.addActionListener(listener);
		btnLeft.addActionListener(listener);
		btnRight.addActionListener(listener);
		btnDownLeft.addActionListener(listener);
		btnDown.addActionListener(listener);
		btnDownRight.addActionListener(listener);
		btnSetText.addActionListener(listener);

		OpenDirectoryListener odListener = new OpenDirectoryListener();
		btnBigRight.addActionListener(odListener);
		btnSetText.addActionListener(new DecideText());
		btnCenter.addActionListener(new Stop());

	}
	
	/**
	 * Metod för att applicera arrayen på colordisplayen
	 * 
	 */

	public void addArray() {
		Array7x7 array[][] = mc.getDisplayArray();
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				cd.setDisplay(array[row][col].toIntArray(), row, col);
			}
		}
		cd.updateDisplay();
	}

	
	/**
	 * En inre klass för att aktivera den rinnande texten så att den körs var 
	 * 100:e millisekund och startar 100 millisekunder efter knappen har tryckts
	 * 
	 * @param e Det objekt vi använder
	 */
	private class ScrollerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ScrollerTask task = new ScrollerTask((JButton) e.getSource());//kastar e.getsource t JButon 
			pauseText();
			timer = new Timer();
			timer.schedule(task, 100, 100);
		}
	}
	
	/**
	 * Metod för att stoppa den rinnande texten
	 * 
	 */

	private void pauseText() {
		if (scrolling == true) {
			timer.cancel();
			timer.purge();
			scrolling = false;
		}
	}

	/**
	 * En inre klass för att bestämma hur texten ska rinna beroende på vilken knapp användaren trycker på
	 * 
	 * @param input Objekt som kontruktorn tar emot
	 */
	
	private class ScrollerTask extends TimerTask {
		private JButton input;

		public ScrollerTask(JButton input) {
			this.input = input;
		}

		@Override
		public void run() {
			if (input.equals(btnUpLeft)) {
				mc.shiftTextLeft();
				mc.shiftTextUp();
			} else if (input.equals(btnUp)) {
				mc.shiftTextUp();
			} else if (input.equals(btnUpRight)) {
				mc.shiftTextUp();
				mc.shiftTextRight();
			} else if (input.equals(btnLeft)) {
				mc.shiftTextLeft();

			} else if (input.equals(btnRight)) {
				mc.shiftTextRight();
			} else if (input.equals(btnDownLeft)) {
				mc.shiftTextDown();
				mc.shiftTextLeft();
			} else if (input.equals(btnDown)) {
				mc.shiftTextDown();
			} else if (input.equals(btnDownRight)) {
				mc.shiftTextDown();
				mc.shiftTextRight();
			}
			scrolling = true;
			mc.finalizeDisplayArray();
			addArray();

		}
	}
	
	/**
	 * En inre klass för att stoppa den rinnande texten 
	 * 
	 * @param e Det objekt metoden använder
	 */
	
	private class Stop implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pauseText();
		}
	}

	/**
	 * En inre klass för att sätta texten till det användaren skriver in i swing-komponenten JOptionPane
	 * 
	 * @param e Det objekt metoden använder
	 */
	
	private class DecideText implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input = JOptionPane.showInputDialog(null, "Write the text you wish to display");
			mc.setText(input);
			mc.finalizeDisplayArray();
			addArray();
		}
	}

	/**
	 * En inre klass för att sätta bilden som användaren anger
	 * 
	 * @param e Det objekt metoden använder
	 */
	
	private class OpenDirectoryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ret = fileChooser.showOpenDialog(null);
			if (e.getSource() == btnBigRight) {
				try {
					if (ret == JFileChooser.APPROVE_OPTION) {
						Picture picture = new Picture(fileChooser.getSelectedFile());
						mc.addPictureToBackground(picture, Color.TRANSPARENT);
						mc.finalizeDisplayArray();
						addArray();
					}
				} catch (Exception ex) {
					System.out.println("File is not an image");
				}
			}
		}
}}

