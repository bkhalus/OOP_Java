public class Application {
	public static void main (String[] args) {

		if (args[0].length() < 1) {

		} else if (args[0] == null) {

		} else {

			String str = args[0];
			int c = 0;

			for (int i = 0; i < str.length()-1; i++) {

				if (str.substring(i+1,i+2).matches("\\d")) {
					c = Character.getNumericValue(str.charAt(i+1));
					for(int j = 0; j < c; j++) {
						System.out.print(str.charAt(i));
					}
				}  else if (!str.substring(i,i+1).matches("\\d")) {
					System.out.print(str.charAt(i));
				}

			}

		}

	}
}