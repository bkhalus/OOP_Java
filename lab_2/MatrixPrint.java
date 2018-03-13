public class MatrixPrint {

	public static void main (String[] args) {

		int size = 5;
		int counter = 1;

		for (int i = 0; i <size; i++) {
			for (int j = 0; j <size; j++) {
				if ((i == j)||( i + j == size-1)) {
					System.out.print(" * ");
				} else if (counter > 9) {
					System.out.print(counter + " ");
				} else {
					System.out.print(" " + counter + " ");
				}
				System.out.print(" ");
				counter++;
			}
			System.out.print("\n");
		}

	}

}