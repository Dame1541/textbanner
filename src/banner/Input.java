package banner;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Klassen Input ansvarar för att skicka vidare en användares input i rutan och skickar
 * sedan vidare detta till controllern.
 * @author Patrik
 *
 */

public class Input extends JPanel implements ActionListener {
	//JPanels för vårt fönster
	private JPanel mainPan = new JPanel();
	private JPanel upper = new JPanel();
	private JPanel bottom = new JPanel();
	private JPanel rightArr = new JPanel();
	private JPanel downArr = new JPanel();
	private JPanel rightArrayen = new JPanel(new GridLayout(7,1,18,18));
	private JPanel downArrayen = new JPanel(new GridLayout(1,7,18,18));
	private JPanel upperColSpace = new JPanel();
	private JPanel bottomColSpace = new JPanel();

	//Knappar för vår inputdisplay som gör olika funktioner
	private JButton readCol = new JButton("Read column");
	private JButton writeCol = new JButton("Write column");
	private JButton readRow = new JButton("Read row");
	private JButton writeRow = new JButton("Write row");

	//JLabel och JTextField som hjälper oss att navigera i panelen
	private JLabel colNbr = new JLabel("Column nbr:");
	private JTextField colNbrText = new JTextField();
	private JLabel rowNbr = new JLabel("Row nbr:");
	private JTextField rowNbrText = new JTextField();

	//Fonten för vår text/siffror
	private Font font = new Font( "SansSerif", Font.PLAIN, 16 );

	//String som "översätter" vår input i JTextField till int som skickas vidare till kontrollern
	private String textCol;
	private String textRow;

	//Kontrollern som instansvariabel
	private Controller controller;

	//JTextField för våra arrays i panelen
	private JTextField[] rightArray = new JTextField[7];
	private JTextField[] downArray = new JTextField[7];

	//Dessa instansvariablerna behövs vid skrivning av row och kolumn
	private String tempCol;
	private String tempRow;
	private int valueCol;
	private int valueRow;

	/**
	 * Vår konstruktor där hela panellen/fönstret byggs upp
	 * @param controller behövs för kopplingen till controller-klassen
	 */
	public Input(Controller controller) {
		this.controller = controller;
		initiateRightArray();
		initiateDownArray();

		setPreferredSize(new Dimension (600, 500));
		setLayout(new BorderLayout(0,0));

		mainPan.setPreferredSize(new Dimension(480,380));

		upperColSpace.setPreferredSize(new Dimension(460,70));
		upper.setPreferredSize(new Dimension(480,190));
		upper.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		bottom.setPreferredSize(new Dimension(480,190));
		bottom.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
		bottomColSpace.setPreferredSize(new Dimension(460,70));

		colNbrText.setPreferredSize(new Dimension(35,25));
		readCol.setPreferredSize(new Dimension(460,50));
		writeCol.setPreferredSize(new Dimension(460,50));

		rowNbrText.setPreferredSize(new Dimension(35,25));
		readRow.setPreferredSize(new Dimension(460,50));
		writeRow.setPreferredSize(new Dimension(460,50));

		rightArr.setPreferredSize(new Dimension(130,370));
		rightArrayen.setPreferredSize(new Dimension(40,380));

		downArr.setPreferredSize(new Dimension(480,80));
		downArrayen.setPreferredSize(new Dimension(400,40));	

		add(mainPan, BorderLayout.WEST);
		add(rightArr, BorderLayout.EAST);
		add(downArr, BorderLayout.SOUTH);

		mainPan.add(upper, BorderLayout.NORTH);
		upper.add(upperColSpace, BorderLayout.NORTH);
		upperColSpace.add(colNbr, BorderLayout.NORTH);
		upperColSpace.add(colNbrText, BorderLayout.NORTH);
		upper.add(readCol, BorderLayout.SOUTH); //knappen som aktiverar contr readCol
		upper.add(writeCol, BorderLayout.SOUTH);

		mainPan.add(bottom, BorderLayout.SOUTH);
		bottom.add(bottomColSpace, BorderLayout.SOUTH);
		bottomColSpace.add(rowNbr, BorderLayout.SOUTH);
		bottomColSpace.add(rowNbrText, BorderLayout.SOUTH);
		bottom.add(readRow, BorderLayout.NORTH);
		bottom.add(writeRow, BorderLayout.NORTH);

		rightArr.add(rightArrayen, BorderLayout.CENTER);
		downArr.add(downArrayen, BorderLayout.WEST);

		//Lyssnare för knappar
		readCol.addActionListener(this);
		writeCol.addActionListener(this);
		readRow.addActionListener(this);
		writeRow.addActionListener(this);
	}

	/**
	 * Metod som initierar högerarrayen
	 */
	public void initiateRightArray() {
		for(int i = 0; i < rightArray.length; i++) {
			rightArray[i] = new JTextField();
			rightArray[i].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
			rightArray[i].setFont(font);
			rightArrayen.add(rightArray[i]);
		}
	}

	/**
	 * Metod som tar vår input i JTextField och skriver över den valda kolumnen i vår array
	 * @return elementen i JTextFields
	 */
	public Array7 writeColumnArray() {
		Array7 writeColArray = new Array7();
		for(int i = 0; i < 7; i++) {
			tempCol = rightArray[i].getText();
			valueCol = Integer.parseInt(tempCol);
			writeColArray.setElement(i, valueCol);
		}
		return writeColArray;
	}

	/**
	 * Metod som tar vår input i JTextField och skriver över den valda raden i vår array
	 * @return elementen i JTextFields
	 */
	public Array7 writeRowArray() {
		Array7 writeRowArray = new Array7();
		for(int i = 0; i < 7; i++) {
			tempRow = downArray[i].getText();
			valueRow = Integer.parseInt(tempRow);
			writeRowArray.setElement(i, valueRow);
		}
		return writeRowArray;
	}

	/**
	 * Metod som initierar bottenarrayen
	 */
	public void initiateDownArray() {
		for(int row = 0; row < downArray.length; row++) {
			downArray[row] = new JTextField();
			downArray[row].setBorder(BorderFactory.createMatteBorder(7, 10, 7, 10, java.awt.Color.WHITE));
			downArray[row].setFont(font);
			downArrayen.add(downArray[row]);
		}
	}

	/**
	 * Metod som gör om vår input i JTextFielden till String, som vi sedan konverterar till int
	 * under actionPerformed för att kunna specificera kolumnen som vi vill läsa/ändra
	 */
	public void getTextFromColField() {
		textCol = colNbrText.getText();
	}

	/**
	 * Metod som gör om vår input i JTextFielden till String, som vi sedan konverterar till int
	 * under actionPerformed för att kunna specificera raden som vi vill läsa/ändra
	 */
	public void getTextFromRowField() {
		textRow = rowNbrText.getText();
	}

	/**
	 * Metoden ansvarar för att en funktion ska göras då en knapp trycks in
	 */
	public void actionPerformed(ActionEvent e) { 

		//Om "read column" knappen trycks in, så skickar vi vidare vilken kolumn vi vill läsa till kontrollern
		if( e.getSource() == readCol) {
			getTextFromColField();
			controller.readColumn(Integer.parseInt(textCol));
		}

		//Om "write column" knappen trycks in, s� skickar vi vidare vår inskrivna array i JTextField rutorna och skriver över den valda kolumnen
		if( e.getSource() == writeCol) {
			getTextFromColField();
			controller.writeColumn(Integer.parseInt(textCol), writeColumnArray());
		}

		//Om "read row" knappen trycks in, så skickar vi vidare vilken rad vi vill l�äa till kontrollern
		if( e.getSource() == readRow) {
			getTextFromRowField();
			controller.readRow(Integer.parseInt(textRow));
		}

		//Om "write row" knappen trycks in, så skickar vi vidare vår inskrivna array i JTextField rutorna och skriver över den valda raden
		if( e.getSource() == writeRow) {
			getTextFromRowField();
			controller.writeRow(Integer.parseInt(textRow), writeRowArray());
		}
	}
}