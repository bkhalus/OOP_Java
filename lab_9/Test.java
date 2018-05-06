public class Test {

	public static void main (String[] args) {

		Deck testDeck = new Deck();

		testDeck.printAllCards();

		System.out.println();

		testDeck.printSize();

		testDeck.drawOne();

		testDeck.printAllCards();

		System.out.println();

		testDeck.printSize();

		testDeck.shuffle();

		testDeck.printAllCards();

		System.out.println();

		testDeck.printSize();

		testDeck.order();

		testDeck.printAllCards();

		System.out.println();

		testDeck.printSize();



	}

}