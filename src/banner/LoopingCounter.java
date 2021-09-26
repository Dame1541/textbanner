package banner;

/**
 * En klass för att skapa en räknare som loopar
 * @author filip
 *
 */
public class LoopingCounter {
	private int counter = 0;
	private int low = 0;
	private int high;
	
	/**
	 * Konstruktor som tar emot en övre gräns
	 * @param high
	 */
	public LoopingCounter(int high) {
		this.high = high;
	}
	
	/**
	 * Konstruktor som tar emot en lägre och en över gräns
	 * @param low
	 * @param high
	 */
	public LoopingCounter(int low, int high) {
		this(high);
		this.low = low;
	}
	
	/**
	 * Konstruktor som tar emot en lägre och övre gräns, samt en startpunkt
	 * @param low
	 * @param high
	 * @param beginAt
	 */
	public LoopingCounter(int low, int high, int beginAt) {
		this(low, high);
		this.counter = beginAt;
	}
	
	/**
	 * Öka räknaren med ett
	 */
	public void increase() {
		counter++;
		if (counter > high)
			counter = low;
	}
	
	/**
	 * Minska räknaren med ett
	 */
	public void decrease() {
		counter--;
		if (counter < low)
			counter = high;		
	}
	
	/**
	 * Hämta räknarens värde
	 * @return
	 */
	public int getCounter() {
		return counter;
	}
}