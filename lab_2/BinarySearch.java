public class BinarySearch {

	public static void main(String[] args) {

		int data[] = { 3, 6, 7, 10, 34, 56, 60 };
		int numberToFind = 10;

		int found = 0;

		// PUT YOUR CODE HERE
        for (int i = 0; i < 7; i++) {
            if (numberToFind == data[i]) {
            	System.out.println(i);
            	found = 1;
            	return;
            }
        }

        if (found == 0) {
        	System.out.println("-1");
        }
		// PUT YOUR CODE HERE
	}
}  