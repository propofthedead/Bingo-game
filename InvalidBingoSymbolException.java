/**
 * 
 */

/**
 * @author wernerla InvalidBingoSymbolException
 */
public class InvalidBingoSymbolException extends Exception {

	/**
	 * 
	 */
	public InvalidBingoSymbolException() {
		// TODO Auto-generated constructor stub
		super("Card character must be B, I, N, G or O");
	}

	public InvalidBingoSymbolException(String msg) {
		super(msg);
	}

}
