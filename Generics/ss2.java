import java.util.Arrays;

public class ss2<E extends Comparable<E>> {

	public static void main(String[] args) {
		
		Player ronaldo = new Player("Ronaldo", 91, 94, 86, 90, 32);
		Player modric = new Player("Modric", 88, 92, 99, 98, 87);
		Player messi = new Player("Messi", 90, 92, 89, 97, 28);
		Player mbappe = new Player("Mbappe", 98, 95, 91, 97, 60);
		
		Player[] pArr = {ronaldo, modric, messi, mbappe};
		
		ss2<Player> playerSort = new ss2<Player>();
		
		playerSort.sort(pArr);
		
		for (int i=0; i<pArr.length; i++)
			System.out.println((i+1) + ". " + pArr[i].getName());
	}
	
	public E[] sort(E[] a) {
		
		for (int i=1; i < a.length; i++) {
			E key = a[i];
			int j = i;
			
			while (j > 0) {
				if (a[j-1].compareTo(key) < 0) {
					E tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
				j--;
			}
		}
		return a;
	}

}
