public class Test {

	public static void main (String[] args) {

		LinkedList list = new LinkedList();

		for (int i = 0; i < 15; i++) {
			list.add(i);
		}

		list.printAll();

		System.out.println();
		System.out.println(list.size());

		System.out.println(list.get(5));

		list.delete(5);

		list.printAll();		

	}

}