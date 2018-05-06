import java.util.Scanner;
import java.io.*;

public class Main 
{
	static String getWord(String text, int begin, int end) {
		String res = "";
		for (int i = begin; i < end; i++)
		{
			res += text.charAt(i);
		}
		return res;
	}

	public static void main (String []args) throws Exception
	{
		// Input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter text: ");
		String text = scanner.nextLine();
		text += " ";
		System.out.println("Enter k: ");
		int K = scanner.nextInt();
		System.out.println("Set Character to change to: ");
		char charToChangeTo = scanner.next().charAt(0);
		
		// Create file for otput
		File file = new File(".\\result.txt");
		FileWriter table = new FileWriter(file);
		table.write(String.format("%32s%10s%16s \r\n", "word before", "" , "word after"));

		// Output
		int prev = 0;
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == ' ') {

				String word = getWord(text, prev, i);
				if (word.length() == 0)
				{
					continue;
				}
				String wordAfter = word;
				prev = i+1;
				if (word.length() < K) {
					wordAfter = K + " > " + word.length();
					table.write(String.format("%32s%10s%16s \r\n", word, "", wordAfter));
				}
				else {
					wordAfter = wordAfter.substring(0, K-1) + charToChangeTo + wordAfter.substring(K);
					table.write(String.format("%32s%10s%16s \r\n", word, "", wordAfter));
				}

			}
		}

		// Close Program
		table.flush();
		table.close();
		System.out.println("Done!");
	}
}