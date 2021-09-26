package banner;

import java.awt.*;
import javax.swing.*;

/**
 * Klassen ansvarar för att visa en 7x7 Array och delar av den
 * på en display.
 * @author Patrik Skuza
 *
 */

public class Viewer extends JPanel {
	/**
	 * JPanels och JLabels
	 */
	private JPanel panel = new JPanel(new GridLayout(7,7,18,18));
	private JPanel leftColumn = new JPanel(new GridLayout(7,1,18,18));
	private JLabel array7x7 = new JLabel("Column                                                      Array7x7");
	private JLabel row = new JLabel("Row");

	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel southPanel = new JPanel(); 
	private JPanel sydPanel = new JPanel();
	private JPanel southRowPanel = new JPanel();
	private JPanel centerPanel = new JPanel();

	/**
	 * En gemensam font som vi har valt att använda för moment 2
	 */
	private Font font = new Font( "SansSerif", Font.PLAIN, 16 );

	/**
	 * JLabels som är hållare för våra arrays.
	 */
	private JLabel[][] centerArray = new JLabel[7][7];
	private JLabel[] leftArray = new JLabel[7];
	private JLabel[] southArray = new JLabel[7];

	/**
	 * Konstruktorn där hela displayen byggs upp.
	 */
	public Viewer() {
		initiateArrayLeftColumn();
		initiateArray7x7();
		initiateArraySouthRow();
		setPreferredSize(new Dimension (600, 500));
		setLayout(new BorderLayout(0,0));

		array7x7.setFont(font);
		array7x7.setPreferredSize(new Dimension(550,30));

		row.setFont(font);

		leftPanel.setPreferredSize(new Dimension(50,370));
		rightPanel.setPreferredSize(new Dimension(50,370));
		sydPanel.setPreferredSize(new Dimension(600,50));
		southPanel.setPreferredSize(new Dimension(545,50));
		centerPanel.setPreferredSize(new Dimension(300,370));

		add(array7x7, BorderLayout.NORTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(sydPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);

		leftPanel.add(leftColumn, BorderLayout.WEST);
		sydPanel.add(southRowPanel, BorderLayout.WEST);
		southRowPanel.add(row, BorderLayout.WEST);
		sydPanel.add(southPanel, BorderLayout.WEST);
		centerPanel.add(panel, BorderLayout.CENTER);
	}

	/**
	 * Metod för att initiera Array7x7
	 */
	public void initiateArray7x7() {
		for(int row = 0; row < centerArray.length; row++) {
			for(int col = 0; col < centerArray[row].length; col ++) {
				centerArray[row][col] = new JLabel();
				centerArray[row][col].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
				centerArray[row][col].setFont(font);
				panel.add(centerArray[row][col]);
			}
		}
	}

	/**
	 * Metod för att fylla Array7x7
	 * @param array7x7 hänvisar till Array7x7-klassen
	 * och används för att ändra innehållet i Arrayen
	 */
	public void setCenterArray(Array7x7 array7x7) {
		for(int row = 0; row < centerArray.length; row++) {
			for(int col = 0; col < centerArray[row].length; col ++) {
				centerArray[row][col].setText(String.valueOf(array7x7.getElement(row,col)));
			}
		}
	}

	/**
	 * Metod för att initiera vänsterkolumnen på fönstret.
	 */
	public void initiateArrayLeftColumn() {
		for(int row = 0; row < leftArray.length; row++) {
			leftArray[row] = new JLabel();
			leftArray[row].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
			leftArray[row].setFont(font);
			leftColumn.add(leftArray[row]);
		}
	}

	/**
	 * Metod för att fylla vänsterkolumnen
	 * @param array7 hänvisar till Array7x7-klassen
	 * och används för att ändra innehållet i Arrayen
	 */
	public void setArrayLeftColumn(Array7 array7) {
		for(int i = 0; i < leftArray.length; i++) {
			leftArray[i].setText(String.valueOf(array7.getElement(i)));
		}
	}

	/**
	 * Metod för att fylla bottenarrayen
	 * @param array7 hänvisar till Array7x7-klassen
	 * och används för att ändra innehållet i Arrayen
	 */
	public void setArrayBottomColumn(Array7 array7) {
		for(int i = 0; i < southArray.length; i++) {
			southArray[i].setText(String.valueOf(array7.getElement(i)));
		}
	}

	/**
	 * Metod för att initiera bottenraden
	 */
	public void initiateArraySouthRow() {
		for(int i = 0; i < southArray.length; i++) {
			southArray[i] = new JLabel();
			southArray[i].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
			southArray[i].setFont(font);
			southPanel.add(southArray[i]);
		}
	}
}