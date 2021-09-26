package banner;

import java.util.Arrays;

/**
 * En klass som initerar en 2D-array vars rader och kolumner går att manipulera.
 * Används utav alla klasser i projektet.
 * 
 * @author Amanda Eriksson
 */

public class Array7x7 {
	private int[][] array2;

	/**
	 * 
	 * Konstruerar och initialiserar en 2D-array av storlek 7x7
	 * 
	 */
	public Array7x7() {
		array2 = new int[7][7];
	}

	/**
	 * 
	 * Konstruerar och initialiserar en 2D-array
	 * 
	 * @param array7x7 Den array som konstruktorn tar emot
	 */

	public Array7x7(Array7x7 array7x7) {
		this();
		setArray(array2);
	}

	/**
	 * 
	 * Konstruerar och initialiserar en kopia utav en 2D-array
	 * 
	 * @param array2 Den array som konstruktorn tar emot
	 */
	public Array7x7(int[][] array2) {
		this.array2 = array2.clone();
	}

	/**
	 * Metod för att sätta ett värde på en position som anges utav row och col
	 * 
	 * @param row   Raden värdet sätts på
	 * @param col   Columnen värdet sätts på
	 * @param value Värdet som sätts på row och col
	 */
	public void setElement(int row, int col, int value) {
		if (row >= 0 && row < array2.length && col >= 0 && col < array2.length) {
			array2[row][col] = value;
		}
	}

	/**
	 * Metod för att hämta värdet på positionen som anges utav row och col
	 * 
	 * @param row Raden som ska initieras
	 * @param col Columnen som ska initieras
	 * @return int Elementet som returneras på positionen 
	 */
	public int getElement(int row, int col) {
		return array2[row][col];

	}

	/**
	 * Metod för skicka in en rad som ska appliceras på objektet
	 * 
	 * @param row    Raden som det ska appliceras på
	 * @param theRow Objektet som anger elementen på raden
	 */
	public void setRow(int row, Array7 theRow) {
		for (int i = 0; i < array2.length; i++) {
			array2[row][i] = theRow.getElement(i);
		}
	}

	/**
	 * Metod för att hämta värderna på raden
	 * 
	 * @param row Raden objektet returneras från
	 * @return Array7 Objektet som returneras
	 */
	public Array7 getRow(int row) {
		Array7 ny = new Array7();
		for (int i = 0; i < array2[row].length; i++) {
			ny.setElement(i, array2[row][i]);
		}
		return ny;
	}

	/**
	 * Metod för skicka in kolumn som ska appliceras på objektet
	 * 
	 * @param col    Kolumnen som ska initieras
	 * @param theCol Objektet som anger elementet på kolumnen
	 */
	public void setCol(int col, Array7 theCol) {
		for (int i = 0; i < array2.length; i++) {
			array2[i][col] = theCol.getElement(i);
		}
	}

	/**
	 * Metod för att hämta värderna på kolumnen
	 * 
	 * @param col Kolumnen objektet returneras från
	 * @return Array7 Objektet som returneras
	 */
	public Array7 getCol(int col) {
		Array7 ny = new Array7();
		for (int i = 0; i < array2[col].length; i++) {
			ny.setElement(i, array2[i][col]);
		}
		return ny;
	}

	/**
	 * Metod för att initiera en 2D-array med Array7x7-objekt
	 * 
	 * @param array7x7 Den array som metoden tar emot
	 */
	public void setArray(Array7x7 array7x7) {
		array2 = array7x7.toIntArray();
	}

	/**
	 * Metod för att initiera en kopia utav en 2D-array
	 * 
	 * @param array Den array som tas emot
	 */
	public void setArray(int[][] array) {
		this.array2 = array.clone();
	}

	/**
	 * Metod för att initiera och returnera en ny instans av Array7x7
	 * 
	 * @return Array7x7 Objekt som returneras
	 */

	public Array7x7 getArray() {
		Array7x7 ny = new Array7x7();
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				ny.setElement(i, j, array2[i][j]);
			}
		}
		return ny;
	}

	/**
	 * Metod för att initiera en ny instans utav 2D-arrayen samt returnera denna
	 * 
	 * @return int[][] Objekt som returneras
	 */
	public int[][] toIntArray() {
		int[][] ny = new int[7][7];
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				ny[i][j] = array2[i][j];
			}
		}
		return ny;
	}

	/**
	 * Metod för att flytta värdet på en position ett steg till vänster i arrayen
	 * 
	 * @param a7 Kolumn som stoppas in till höger
	 * @return Array7 Objektet som returneras
	 */
	public Array7 shiftLeft(Array7 a7) { // behöver bara jobba i kolumner pga vänster och höger ej upp och ned
		Array7 retArray7 = this.getCol(0);// sparar densom stoppar us så att den sparas , annars försvinner den
		for (int i = 0; i < array2.length - 1; i++) {
			this.setCol(i, this.getCol(i + 1)); // stoppar in värden från en pos (till höger om den pos vi jobbar med)
			// i den pos vi jobbar med, dvs shiftar vänster
		} // får in en col och får ut en col, tar in ett a7 och stoppar in från parameter
		this.setCol(6, a7);
		return retArray7;
	}

	/**
	 * Metod för att flytta värdet på en position ett steg till höger i arrayen
	 * 
	 * @param a7 Kolumn som stoppas in till vänster
	 * @return Array7 Objektet som returneras
	 */
	public Array7 shiftRight(Array7 a7) {
		Array7 retArray7 = this.getCol(6);
		for (int i = array2.length - 1; i > 0; i--) {
			this.setCol(i, this.getCol(i - 1));
		}
		this.setCol(0, a7);
		return retArray7;
	}

	/**
	 * Metod för att flytta värdet på en position ett steg upp i arrayen
	 * 
	 * @param a7 Rad som stoppas in längst ned
	 * @return Array7 Objektet som returneras
	 */
	public Array7 shiftUp(Array7 a7) {
		Array7 retArray7 = this.getRow(0);
		for (int i = 0; i < array2.length - 1; i++) {
			this.setRow(i, this.getRow(i + 1));
		}
		this.setRow(6, a7);
		return retArray7;
	}

	/**
	 * Metod för att flytta värdet på en position ett steg ned i arrayen
	 * 
	 * @param a7 Rad som stoppas in längst upp
	 * @return Array7 Objektet som returneras
	 */
	public Array7 shiftDown(Array7 a7) {
		Array7 retArray7 = this.getRow(6);
		for (int i = array2.length - 1; i > 0; i--) {
			this.setRow(i, this.getRow(i - 1));
		}
		this.setRow(0, a7);
		return retArray7;
	}
}
