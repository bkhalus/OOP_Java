public class Fibonacci {

	public static long getNumber(int position) {

		if ((position == 2)||(position == 1)) {
			return 1;
		} else if (position < 1) {
			return -1;
		} else {
			return (Fibonacci.getNumber(position-1) + Fibonacci.getNumber(position-2));
		}

	}

}