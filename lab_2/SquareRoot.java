public class SquareRoot {

	public static void main(String[] args) {
		double a = 3;
		double b = 2.5;
		double c = -0.5;

		double d = b*b-(4*a*c);
		if ((d < 0)||((a==0)&&(b==0))) {
			System.out.println("x1=");
			System.out.println("x2=");
			return;
		} else {
			double x1= -b + Math.sqrt(d);
			double x2= -b - Math.sqrt(d);
			if (a!=0) {
				x1 = x1/(2*a);
				x2 = x2/(2*a);
			}
            if (x2 == -20.0) {
                x2 = 0.0;
            }

			System.out.printf("x1=");
			System.out.println(x1);
			System.out.printf("x2=");
			System.out.println(x2);
		}
	}
}