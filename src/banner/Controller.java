package banner;

/**
 * Klassen Controller ansvarar för att skicka vidare vår input i Input-klassen till Array7x7-klassen
 * och returnerar/skickar sedan vidare resultatet till Viewer-klassen.
 * @author Patrik Skuza
 *
 */

public class Controller {

	/**
	 * Testarray för viewer- och inputklasserna.
	 */
	private int[][] testArray = {
			{1, 8, 4, 6, 9, 0, 0},
			{2, 9, 0, 6, 8, 2, 0},
			{2, 5, 0, 6, 5, 9, 0},
			{6, 1, 0, 9, 4, 4, 0},
			{8, 6, 2, 6, 5, 9, 0},
			{7, 5, 0, 6, 1, 8, 0},
			{1, 0, 0, 6, 1, 9, 0},
	};

	/**
	 * Instansvariabler för klasserna Viewer och Array7x7.
	 */
	private Array7x7 array = new Array7x7();
	private Viewer viewer;

	/**
	 * Konstruktorn ser till att fylla ut vår 7x7 centerarray i Viewern och skapar
	 * kopplingen mellan allt som sker och viewern-klassen där resultatet visas.
	 * @param viewer skapar kopplingen till viewer-klassen.
	 */
	public Controller(Viewer viewer) {
		this.viewer = viewer;
		array.setArray(testArray);
		viewer.setCenterArray(array);
	}

	/**
	 * Metoden skickar vidare vår input och hämtar resultatet i Array7x7,
	 * och visar sedan vår row i viewern.
	 * @param row är vår input och hämtar row "x"
	 */
	public void readRow(int row) {
		Array7 readR = array.getRow(row);
		viewer.setArrayBottomColumn(readR);
	}

	/**
	 * Metoden skickar vidare vår input och hämtar resultatet i Array7x7,
	 * och visar sedan vår kolumn i viewern.
	 * @param col är vår input och hämtar col "x"
	 */
	public void readColumn(int col) {
		Array7 readC = array.getCol(col);
		viewer.setArrayLeftColumn(readC);
	}

	/**
	 * Metoden skickar vidare vår input och tillämpar den nya kolumnen
	 * i Array7x7.
	 * @param col är vår input och tillämpar det i Array7x7.
	 * @param arr7 är vårt Array7-objekt som skickas vidare till Array7x7.
	 */
	public void writeColumn(int col, Array7 arr7) {
		array.setCol(col, arr7);
		viewer.setCenterArray(array);
	}

	/**
	 * Metoden skickar vidare vår input och tillämpar den nya raden
	 * i Array7x7.
	 * @param row är vår input och tillämpar det i Array7x7.
	 * @param arr7 är vårt Array7-objekt som skickas vidare till Array7x7.
	 */
	public void writeRow(int row, Array7 arr7) {
		array.setRow(row, arr7);
		viewer.setCenterArray(array);
	}
}