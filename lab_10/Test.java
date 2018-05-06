public class Test 
{

	public static void main (String[] args)
	{

		Excursion ex = new Excursion("08 04 2018", "23 00 00", 180, "Lviv", "Night Walk");

		ex.addParticipant("Nazar");
		ex.addParticipant("Bohdan");
		ex.addParticipant("Roman");

		ex.print();

	}

}