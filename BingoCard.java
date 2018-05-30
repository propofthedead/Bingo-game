
/** 
 * Class that represents a standard bingo card.
 * 
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * A Bingo card has five rows and five columns. A Bingo card has 25 Bingo Balls.
 * In this implementation, the 25 BingoBall objects are stored in a LinkedList
 * 
 * @author Laurie Werner
 * @version May 2018
 *
 */
class BingoCard extends BingoBall {

	private LinkedList<BingoBall> bingoCardlist;

	/**
	 * Constructor that initializes a standard bingo card with a unique set of
	 * BingoBall objects All BingoBall objects on the card are marked false
	 */
	@SuppressWarnings("unchecked")
	public BingoCard() throws InvalidBingoSymbolException, InvalidBingoValueException {
		bingoCardlist = new LinkedList<BingoBall>();
		// for 5 columns, generate random BingoBalls in the allowed number range
		for (int i = 0; i < 5; i++) {
			bingoCardlist.add(addUniqueBall(1, FIFTEEN, 'B')); // column 1
			// System.out.println(bingoCardlist.toString());

			bingoCardlist.add(addUniqueBall((FIFTEEN + 1), THIRTY, 'I')); // column
																			// 2
			bingoCardlist.add(addUniqueBall((THIRTY + 1), FORTYFIVE, 'N')); // column
																			// 3
			bingoCardlist.add(addUniqueBall((FORTYFIVE + 1), SIXTY, 'G')); // column
																			// 4
			bingoCardlist.add(addUniqueBall((SIXTY + 1), SEVENTYFIVE, 'O')); // column
																				// 5
		}
		// Sort the linked list of BingoBalls
		Collections.sort(bingoCardlist);
	}

	/**
	 * If the given ball is on the card, marks it as played. Method is used
	 * during the game to change the status of a spot on the card to true, which
	 * True means the number has been called
	 * 
	 * @param ball
	 *            to be marked as played
	 * @return true when card to mark is found
	 */
	public boolean mark(BingoBall ball) {
		if (this.bingoCardlist.contains(ball)) {
			int i = this.bingoCardlist.indexOf(ball);
			this.bingoCardlist.get(i).setMarked(true);
		}
		return false;
	}

	/**
	 * This returns true if any row, column, or diagonal is marked. This method
	 * invokes private methods to simplify the process Bingo occurs when all
	 * BingoBalls in a row are marked, or all BingoBalls in a column are marked,
	 * or all BingoBalls on any diagonal are marked.
	 * 
	 * @return true when Bingo occurs, false otherwise.
	 */
	public boolean isBingo() {
		// check columns first
		if (this.columnIsMarked() == true)
			return true;
		// check rows
		if (this.rowIsMarked() == true)
			return true;
		// check diagonals
		if (diagonalLeftToRightIsMarked())
			return true;
		if (diagonalRightToLeftIsMarked())
			return true;
		return false;
	}

	/**
	 * This method checks for a completely marked column
	 * 
	 * @return true if all the BingoBalls in any of the five columns are marked,
	 *         false otherwise
	 */
	private boolean columnIsMarked() {
		// Nested loops to check for five marked balls in a column
		for (int j = 0; j < bingoCardlist.size(); j += 5) {
			int countMarked = 0;
			for (int i = j; i < (j + 5) && i < bingoCardlist.size(); i++)
				if (this.bingoCardlist.get(i).getMarked() == true) {
					countMarked++;
				}
			if (countMarked >= 5)
				return true;
		}
		return false;
	}

	/**
	 * This method checks for any completely marked row
	 * 
	 * @return true if all the BingoBalls in any row are marked true, false
	 *         otherwise
	 */
	private boolean rowIsMarked() {
		// loop for 5 rows
		for (int j = 0; j < 5; j++) {
			int countMarked = 0;
			// loop through one row looking for marked spots
			for (int i = j; i < bingoCardlist.size(); i += 5)
				if (this.bingoCardlist.get(i).getMarked() == true) {
					countMarked++;
				}
			// return if all five are marked
			if (countMarked >= 5)
				return true;
		}
		return false;// no five in a row are marked
	}

	/**
	 * This method checks the left to right diagonal for Bingo marks
	 * 
	 * @return returns true if the left to right diagonal is marked
	 */
	private boolean diagonalLeftToRightIsMarked() {
		// start at upper left corner
		for (int i = 0; i < bingoCardlist.size(); i += 6) {
			if (!(bingoCardlist.get(i).getMarked()))
				return false;
		}
		return true;
	}

	/**
	 * returns true if the diagonal is marked. This method checks the left to
	 * right diagonal for BingoBalls marked true
	 * 
	 * @return returns true if the right to left diagonal is marked
	 */
	private boolean diagonalRightToLeftIsMarked() {
		// start at bottom right corner
		for (int i = 4; i < bingoCardlist.size(); i += 4) {
			if (!(bingoCardlist.get(i).getMarked()))
				return false;
		}
		return true;
	}

	/**
	 * returns true if the BingoBall(col,num) is already in the bingoCardlist
	 * 
	 * @param col
	 *            char representing Bingo column
	 * @param number
	 *            number generated for the card, but may be duplicate
	 * @return true if number is already on the card
	 * @throws InvalidBingoValueException
	 * @throws InvalidBingoSymbolException
	 */
	private boolean numberIsUsed(char col, int number) throws InvalidBingoSymbolException, InvalidBingoValueException {
		// create a ball using parameters
		BingoBall ball = new BingoBall(col, number);
		// Invoke contains method in LinkedLIst class to check if the
		// ball is already on the card
		if (this.bingoCardlist.contains(ball)) {
			return true;
		}
		return false;
	}

	/**
	 * adds a ball in the correct range at the given position for the given
	 * column designation ( column 1 is allowed 1-15, column 2 is allowed 16-30,
	 * etc)
	 * 
	 * @param min
	 *            range minimum for BingoBall value
	 * @param max
	 *            range maximum for BingoBall value
	 * @param row
	 *            row on the card
	 * @param col
	 *            column on the card
	 * @param c
	 *            a character B, I, N, G or O to indicate the char instance data
	 *            to set in the BingoBall
	 */
	private BingoBall addUniqueBall(int min, int max, char c)
			throws InvalidBingoSymbolException, InvalidBingoValueException {
		Random random = new Random();
		int next;
		do {
			next = random.nextInt(max - min + 1) + min;
		} while (numberIsUsed(c, next));

		return new BingoBall(c, next);
	}

	/**
	 * Returns the Bingo Card in a formatted String. If a spot is marked, X is
	 * used, otherwise the numeric value of the ball is used.
	 * 
	 * @return String to print the BingoCard in an application.
	 */
	public String show() {
		String s = String.format("%-4c%-4c%-4c%-4c%-4c\n", B, I, N, G, O);

		for (int row = 0; row < 5; row += 1) {
			for (int col = row; col < bingoCardlist.size(); col += 5) {
				BingoBall b = bingoCardlist.get(col);
				if (!b.getMarked())
					s += String.format("%-4d", b.getValue());
				else
					s += String.format("%-4s", "X");
			}
			s += "\n";
		}
		return s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BingoBall#toString()
	 */
	public String toString() {
		// call the parent toString()
		String s = bingoCardlist.toString();
		return s;
	}

	/**
	 * This main method tests the constructor, show and toString. It also tests
	 * the marking of the BingoCard and determining a winner
	 * 
	 * @param args
	 * @throws InvalidBingoSymbolException
	 * @throws InvalidBingoValueException
	 */
	public static void main(String[] args) throws InvalidBingoSymbolException, InvalidBingoValueException {
		Scanner kb = new Scanner(System.in);
		// construct a card
		BingoCard card = new BingoCard();
		// Test toString()
		System.out.println("card stored in linked list is:" + "\n" + card);
		// Test show
		System.out.println(card.show());
		System.out.println("Testing for winner - should be false because no Balls are marked true");
		System.out.println("Your card is a winner? " + card.isBingo());

		// Testing mark and isBingo

		try {
			System.out.println(
					"Enter 5 BingoBall values in column 'I' from card shown to test mark and isBingo methods.");
			for (int i = 0; i < 5; i += 1) {
				int b = kb.nextInt();
				BingoBall test1 = new BingoBall(I, b);
				card.mark(test1);
			}
			System.out.println("Your card is a winner? " + card.isBingo());
			// Testing a different column
			System.out.println("Enter 5 BingoBall values in column 'N' from card shown to test isBingo method.");
			System.out.println("If you enter the numeric values in column N correctly, you should have Bingo.");
			for (int i = 0; i < 5; i += 1) {
				int b = kb.nextInt();
				BingoBall test1 = new BingoBall(N, b);
				card.mark(test1);
			}
			System.out.println("Your card is a winner? " + card.isBingo());

			System.out.println("Enter 5 BingoBall values on the diagonal from upper left to bottom right.");
			System.out.println("If you enter the numeric values on the diagonal correctly, you should have Bingo.");
			char[] labels = { B, I, N, G, O };
			for (int i = 0; i < 5; i += 1) {
				int b = kb.nextInt();
				BingoBall test1 = new BingoBall(labels[i], b);
				card.mark(test1);
			}
			// testing diagonals
			System.out.println("Your card is a winner? " + card.isBingo());
			System.out.println("Enter 5 BingoBall values on the diagonal from bottom left to upper right.");
			System.out.println("If you enter the numeric values on the diagonal correctly, you should have Bingo.");
			for (int i = 0; i < 5; i += 1) {
				int b = kb.nextInt();
				BingoBall test1 = new BingoBall(labels[i], b);
				card.mark(test1);
			}
			System.out.println("Your card is a winner? " + card.isBingo());
			// testing a row
			System.out.println("Enter 5 BingoBall values across a row from left to right.");
			System.out.println("If you enter the numeric values on a single row correctly, you should have Bingo.");
			for (int i = 0; i < 5; i += 1) {
				int b = kb.nextInt();
				BingoBall test1 = new BingoBall(labels[i], b);
				card.mark(test1);
			}
			System.out.println("Your card is a winner? " + card.isBingo());
			// generate the error
			card.mark(new BingoBall('C', 100));
		} catch (InvalidBingoSymbolException e) {
			System.out.println(e.getMessage());
		} catch (InvalidBingoValueException e) {
			System.out.println(e.getMessage());
		} finally {
			kb.close();
		}
	}

}
