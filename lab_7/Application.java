import java.util.Deque;
import java.util.LinkedList;

public class Application {

	public static double parse(String Str) {
		Deque<Double> deque = new LinkedList<>();
		StringBuilder str = new StringBuilder("");

		Str = Str.trim();

		for (int i = 0, length = Str.length(); i < length; i++)
		{
			char sign = Str.charAt(i);

			if ((sign >= '0' && sign <= '9') || sign == '.' || (sign == '-' && i != length - 1 && Str.charAt(i + 1) != ' '))
			{
				str.append(sign);
			}

			else if (sign == ' ')
			{
				if (str.length() > 0)
				{
					deque.push(Double.valueOf(str.toString()));

					str = new StringBuilder("");
				}
			}

			else if (sign == '+' || sign == '-' || sign == '*' || sign == '/')
			{
				Double first, second;
				try
				{
					second = deque.pop();
					first = deque.pop();
				}
				catch (Exception e)
				{
					throw new RPNParserException();
				}

				switch (sign)
				{
					case '+':
						deque.push(first + second);
						break;

					case '-':
						deque.push(first - second);
						break;

					case '*':
						deque.push(first * second);
						break;

					case '/':
						if (second == 0)
						{
							throw new ArithmeticException();
						}


						deque.push(first / second);
						break;
				}
			}

			else
			{
				throw new RPNParserException();
			}

		}
		if (deque.size() > 1)
		{
			throw new RPNParserException();
		}

		return deque.pop();
	}

	public static void main(String[] args) {
		if (args == null || args.length != 1 || args[0] == null)
		{
			throw new RPNParserException();
		}
		System.out.println(" = " + Application.parse(args[0]));
	}

}