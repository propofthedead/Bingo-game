
/*
 * Bingo Ball
 * Class that represents a location on a bingo Card
 *
 * @author Laurie Werner
 * @version May 2018
 * */

public class BingoBall implements BingoBallInterface, Comparable {
	// instance variables
	private char column; // B or I or N or G or O
	private int value;
	private boolean marked = false;

	/*
	 * constructor
	 */
	public BingoBall() {
	}

	/*
	 * constructor that creates a valid Bingo Ball
	 * 
	 * @param char column char assigned
	 * 
	 * @param int value assigned
	 */
	public BingoBall(char columnIn, int valueIn) throws InvalidBingoSymbolException, InvalidBingoValueException {
		switch (columnIn) {
		case B:
			if (valueIn > 0 && valueIn <= FIFTEEN) {
				this.value = valueIn;
				this.column = columnIn;
			} else {
				throw new InvalidBingoValueException();
			}
			break;
		case I:
			if (valueIn > FIFTEEN && valueIn <= THIRTY) {
				this.value = valueIn;
				this.column = columnIn;
			} else {
				throw new InvalidBingoValueException();
			}
			break;
		case N:
			if (valueIn > THIRTY && valueIn <= FORTYFIVE) {
				this.value = valueIn;
				this.column = columnIn;
			} else {
				throw new InvalidBingoValueException();
			}
			break;
		case G:
			if (valueIn > FORTYFIVE && valueIn <= SIXTY) {
				this.value = valueIn;
				this.column = columnIn;
			} else {
				throw new InvalidBingoValueException();
			}
			break;
		case O:
			if (valueIn > SIXTY && valueIn <= SEVENTYFIVE) {
				this.value = valueIn;
				this.column = columnIn;
			} else {
				throw new InvalidBingoValueException();
			}
			break;
		default:
			throw new InvalidBingoSymbolException();
		}
	}

	/*
	 * accessor get column method
	 * 
	 * @return char column
	 */
	public char getColumn() {
		return this.column;
	}

	/*
	 * accesor get value method
	 * 
	 * @return int value
	 */
	public int getValue() {
		return this.value;
	}

	/*
	 * accesor get marked method
	 * 
	 * @return boolean marked
	 */
	public boolean getMarked() {
		return this.marked;
	}

	/*
	 * Mutator set marked method
	 * 
	 * @param boolean whether or not to mark the Ball
	 */
	public void setMarked(boolean mark) {
		this.marked = mark;
	}

	/*
	 * Equals Method
	 * 
	 * @param object other
	 * 
	 * @return boolean true if equal false if not
	 */
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (!(other instanceof BingoBall))
			return false;
		BingoBall temp = (BingoBall) other;
		if (temp.getValue() == this.getValue() && temp.getColumn() == this.column)
			return true;
		return false;
	}

	/**
	 * This method compares the value of this BingoBall object to the other
	 * BingoBall object
	 * 
	 * @param other
	 *            another BingoBall to compare
	 * @return difference between the two objects
	 */
	public int compareTo(Object other) {
		if (other == null)
			return Integer.MAX_VALUE;
		if (!(other instanceof BingoBall))
			return Integer.MAX_VALUE;
		BingoBall temp = (BingoBall) other;

		return this.getValue() - temp.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + this.column + "-" + this.value + " " + this.marked;
	}

	/*
	 * Main Method for testing
	 */
	public static void main(String[] args) throws InvalidBingoSymbolException, InvalidBingoValueException {
		BingoBall test1 = new BingoBall('G', 52);
		try {
			test1 = new BingoBall('B', 2);
			// BingoBall test2 = new BingoBall('C', 4); // throws exception
			BingoBall test3 = new BingoBall('B', 20);// throws exception
		} catch (InvalidBingoSymbolException e) {
			System.out.println(e.getMessage());
			BingoBall test2 = new BingoBall('N', 40);
			BingoBall test3 = new BingoBall('B', 2);
			System.out.println(test1.toString());
			System.out.println(test2.toString());
			System.out.println("Equals " + test1.equals(test2));
			System.out.println(test3.toString());
			System.out.println("Equals " + test1.equals(test3));

			// test3.setMarked(true);
			System.out.println("Column is " + test3.getColumn());
			System.out.println("Value is " + test3.getValue());
			System.out.println("Marked is " + test3.getMarked());
			// check compareTo
			System.out.println(test3.compareTo(test2));
			System.out.println(test2.compareTo(test3));

		} catch (InvalidBingoValueException e) {
			System.out.println(e.getMessage());
			BingoBall test2 = new BingoBall('N', 40);
			BingoBall test3 = new BingoBall('B', 2);
			System.out.println(test1.toString());
			System.out.println(test2.toString());
			System.out.println("Equals " + test1.equals(test2));
			System.out.println(test3.toString());
			System.out.println("Equals " + test1.equals(test3));

			// test3.setMarked(true);
			System.out.println("Column is " + test3.getColumn());
			System.out.println("Value is " + test3.getValue());
			System.out.println("Marked is " + test3.getMarked());
			// check compareTo
			System.out.println(test3.compareTo(test2));
			System.out.println(test2.compareTo(test3));

		} finally {

			System.out.println("Finished ");

		}
	}

}