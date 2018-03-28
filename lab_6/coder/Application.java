public class Application {
	public static void main(String[] args) {

		if (args.length() < 1) {
			System.out.println("Error");
		} else {

			String str = args[0];
			int counter = 1;
			for (int i = 0; i < str.length() - 1 ; i++) {

				if (str.charAt(i+1) == str.charAt(i) && counter < 9) {
					counter++;
				} 
				else {
					System.out.print("" + str.charAt(i));
					if (counter != 1) System.out.print(Integer.toString(counter));
					counter = 1;
				}

				if ( i == str.length()-2 ) {
					if (str.charAt(i+1) == str.charAt(i)) {
						System.out.print("" + str.charAt(i));	
						if (counter != 1) System.out.print(Integer.toString(counter));
					} else {
						System.out.print("" + str.charAt(i));	
						if (counter != 1) System.out.print(Integer.toString(counter));
						System.out.print("" + str.charAt(i+1));
					}
				}

			}

		}
		
	}
}