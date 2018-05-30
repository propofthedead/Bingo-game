/**
 * 
 */

/**
 * @author wernerla
 *
 */
public interface BingoBallInterface {
	public static final char B = 'B';
	public static final char I = 'I';
	public static final char N = 'N';
	public static final char G = 'G';
	public static final char O = 'O';
	public static final int FIFTEEN = 15;
	public static final int THIRTY = 30;
	public static final int FORTYFIVE = 45;
	public static final int SIXTY = 60;
	public static final int SEVENTYFIVE = 75;

	/**
	 * accessor get column method
	 * 
	 * @return char column B, I, N, G or O
	 */
	public char getColumn();

	/**
	 * accesor get value method
	 * 
	 * @return int value of the ball as an int
	 */
	public int getValue();

	/**
	 * Mutator set marked method
	 * 
	 * @param boolean
	 *            whether or not to mark
	 */
	public void setMarked(boolean mark);

	/**
	 * @return true if the ball is marked, false otherwise
	 */
	public boolean getMarked();
}
