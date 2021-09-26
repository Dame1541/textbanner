package banner;

/**
 * En klass för att initiera en 1D-array. Används utav alla klasser i projektet. 
 * 
 * @author Amanda Eriksson
 */
public class Array7 {
	private int[] array;
	
	/**
	 * 
	 * Konstruerar och initialiserar en 1D-array med storlek 7
	 * 
	 */
	public Array7() {
		array = new int[7];
	}

	/**
	 * 
	 * Konstruerar och initialiserar en 1D-array
	 * @param array7 Den array som konstruktorn tar emot
	 */

	public Array7(Array7 array7) {
		setArray(array7);

	}

	/**
	 * 
	 * Konstruerar och initialiserar en kopia utav en 1D-array
	 * @param array Den array som konstruktorn tar emot
	 */
	public Array7(int[] array) {
		this.array = array.clone();

	}

	/**
	 * Metod för att initiera en 1D-array med värden på en viss position
	 * 
	 * @param pos Positionen i arrayen
	 * @param value Värdet i arrayen
	 */

	public void setElement(int pos, int value) {
		array[pos] = value;

	}
	/**
	 * Metod för att retunera värdet på en positionerna i arrayen
	 * 
	 * @param pos Position i arrayen
	 * @return int Retunerar positionen i arrayen
	 */
	public int getElement(int pos) {
		return array[pos];

	}

	/**
	 * Metod för att initiera en 1D-array med Array7-objekt
	 * 
	 * @param array7 Objekt som används för att hämta elementen
	 */

	public void setArray(Array7 array7) { 
		for (int i = 0; i < array.length; i++) {
			int ny = array7.getElement(i);
			array[i] = ny;
		}
	}

	/**
	 * Metod för att initiera en kopia utav 1D-arrayen
	 * 
	 * @param array Den array som konstruktorn tar emot
	 */
	public void setArray(int[] array) {
		this.array = array.clone();

	}
	
	/**
	 * Metod för att initiera och returnera en ny instans av Array7-objekt
	 * 
	 * @return Array7 Objekt retuneras
	 */

	public Array7 getArray() {
		Array7 ny = new Array7();
		for (int i = 0; i < array.length; i++) {
			ny.setElement(i, array[i]);
		}
		return ny;
	}
	/**
	 * Metod för att initiera en ny instans utav 1D-arrayen samt returnera denna
	 * 
	 * @return int[] Retunerar 1D-array
	 */
	public int[] toIntArray() { 
		return array.clone();
	}
}
