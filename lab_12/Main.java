import java.util.Scanner;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.io.*;

public class Main 
{

	private static ArrayList<Excursion> excursions = new ArrayList<Excursion>();

	private static void save() throws IOException
	{

		FileOutputStream out = null;

		try {

			out = new FileOutputStream("saves.sv");

			for (int i = 0; i < excursions.size(); i++)
			{

				out.write(excursions.get(i).getDate().getBytes(Charset.defaultCharset()));
				out.write((byte)'\n');
				out.write(excursions.get(i).getStartTime().getBytes(Charset.defaultCharset()));
				out.write((byte)'\n');
				out.write(String.valueOf(excursions.get(i).getDuration()).getBytes(Charset.defaultCharset()));
				out.write((byte)'\n');
				out.write(excursions.get(i).getPlace().getBytes(Charset.defaultCharset()));
				out.write((byte)'\n');
				out.write(excursions.get(i).getDescription().getBytes(Charset.defaultCharset()));
				out.write((byte)'\n');
				out.write(String.valueOf(excursions.get(i).getNumberOfParticipants()).getBytes(Charset.defaultCharset()));
				out.write((byte)'\n');

				for (int j = 0; j < excursions.get(i).getNumberOfParticipants(); j++)
				{
					out.write(excursions.get(i).getParticipantName(j).getBytes(Charset.defaultCharset()));
					out.write((byte)'\n');
				}

			}

		} finally {

			out.close();

		}
	}

	private static void restore () throws IOException
	{
		FileInputStream in = null;

		try {

			in = new FileInputStream("saves.sv");
			int cc; int counter = 0; String temp = "";
			int participantsNum = 0;
			Excursion ex = new Excursion();
			while ((cc = in.read()) != -1)
			{
				
				if ((char) cc == '\n')
				{

					counter += 1;

					if (counter == 1)
					{
						ex.setDate(temp);
						temp = "";
					} else if (counter == 2) 
					{
						ex.setStartTime(temp);
						temp = "";
					} else if (counter == 3)
					{
						ex.setDuration(Integer.parseInt(temp));
						temp = "";
					} else if (counter == 4)
					{
						ex.setPlace(temp);
						temp = "";
					} else if (counter == 5)
					{
						ex.setDescription(temp);
						temp = "";
					} else if (counter == 6)
					{
						participantsNum = Integer.parseInt(temp);

						for (int i = 0; i < participantsNum; i++)
						{
							temp = "";
							while ((char)(cc = in.read()) != '\n')
							{
								temp += (char) cc;
							}

							ex.addParticipant(temp);
						}

						excursions.add(ex);
						participantsNum = 0;
						counter = 0;
						temp = "";
						ex = new Excursion();
					}

				} else {
					temp += (char) cc;
				}

			}

		} finally {
			in.close();
		}
	} 

	public static void main (String[] args) throws Exception
	{
		restore();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Type help if you need some help");
		while (true)
		{
			System.out.print("<User>: ");

			String temp = scanner.nextLine();

			if (temp.startsWith("help")) {
				System.out.println("Type \"size\" to get number of excursions \n" +
					"Type \"add excursion\" to add excursion\n" +
					"Type \"print excursion\" to print excursion info\n" +
					"Type \"list\" to get a list of excursions \n" +
					"Type \"delete\" to delete an excursion \n" +
					"Type \"exit\" to exit");
				System.out.println();
			}
			if (temp.startsWith("size")) {
				System.out.println("There are " + (excursions.size()) + " excursions");
				System.out.println();
			}
			if (temp.startsWith("exit")) {
				break;
			}

			if (temp.startsWith("add excursion")) {
				String date = "00 00 0000";
				while (true)
				{
					System.out.println("Eneter Date:  (dd MM yyyy) ");
					date = scanner.nextLine();
					

					if (date.matches("\\d{2} \\d{2} \\d{4}"))
					{
						break;
					}		
				}

				String time = "00:00:00";
				while (true)
				{
					System.out.println("Enter start time: (HH:mm:ss)");
					time = scanner.nextLine();
					
					if (time.matches("\\d{2}:\\d{2}:\\d{2}"))
					{
						break;
					}	
				}
				int duration = 0;
				while (true)
				{
					System.out.println("Enter duration in minutes: ");
					String durationS = scanner.nextLine();
					
					if (durationS.matches("[0-9]+"))
					{
						duration = Integer.parseInt(durationS);
						break;
					}
				}
				System.out.println("Enter place: ");
				String place = scanner.nextLine();
				place = scanner.nextLine();
				System.out.println("Enter description: ");
				String description = scanner.nextLine();
				Excursion ex = new Excursion(date, time, duration, place, description);
				int numOfParticipants = 0;
				while (true)
				{
					System.out.println("Enter number of participants: ");
					String numOfParticipantsS = scanner.nextLine();
					
					if (numOfParticipantsS.matches("[0-9]+"))
					{
						numOfParticipants = Integer.parseInt(numOfParticipantsS);
						break;
					}
				}
				String name = scanner.nextLine();
				for (int i = 0; i < numOfParticipants; i++)
				{
					System.out.println("Enter name of " + (i+1) + " participant: ");
					name = scanner.nextLine(); 
					ex.addParticipant(name);
				}
				excursions.add(ex);
				System.out.println("Excursion created with id " + (excursions.size()-1) +"\n");
			}

			if (temp.startsWith("print excursion")) {
				System.out.println("Enter excursion id: ");
				int id = scanner.nextInt();
				excursions.get(id).print();
				System.out.println();
			}

			if (temp.startsWith("list")) {
				for (int i = 0; i < excursions.size(); i++)
				{
					System.out.print("ID: " + i + " on " + excursions.get(i).getDate() + "\n");
				}
				System.out.println();
			}

			if (temp.startsWith("delete")) {
				System.out.println("Enter excursion id you want to delete: ");
				int id = scanner.nextInt();
				excursions.remove(id);
				System.out.println("Excursion " + id + " deleted!\n");
			}
			
		}
		save();

	}
}