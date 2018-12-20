
public class TestLinkedList {

	public static void main(String[] args) {
		
		ListI<Integer> mylist = new MyLinkedList<Integer>();
		
		mylist.addFirst(10);
		mylist.addFirst(9);
		mylist.addFirst(8);
		mylist.addFirst(7);
		mylist.addLast(3);
		
		Integer e = mylist.remove(10);
		boolean containsNum = mylist.contains(11);
		System.out.println(containsNum);
	}

}
