public class LinkedList {

	private Node head;
	private int size;

	public LinkedList () {
		this.head = new Node();
		this.size = 0;
	}

	public void add(Integer data) {
		Node temp = head;
		for (int i = 0; i < this.size; i++) {
			temp =  temp.getNext();
		}
		temp.setNext(new Node());
		temp.getNext().setData(data);
		this.size++;
	}

	public Integer get(int index) {
		if ((index < 1) || (index > size)) {
			return null;
		} else {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp.getData();
		}
	}

	public boolean delete(int index) {
		if ((index < 1) || (index > size)) {
			return false;
		} else {
			Node temp = head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.getNext();
			}
			if (index == size) {
				temp.setNext(null);
			} else {
				temp.setNext(temp.getNext().getNext());		
			}
			this.size--;
			return true;
		}
	}

	public int size() {
		return size;
	}

	public void printAll () {
		Node temp = head;
		for (int i = 0; i < this.size; i++) {
			temp = temp.getNext();
			temp.printNode();
		}
	}

}