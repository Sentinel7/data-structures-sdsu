
public class ss<E extends Comparable<E>> {

	public static void main(String[] args) {
		Integer[] arr1 = {4,7,4,2};
		String[] arr2 = {"Jason", "Alex", "Mirela", "Ben"};
		
		ss<Integer> s1 = new ss<Integer>();
		ss<String> s2 = new ss<String>();
		
		s1.sort(arr1);
		s2.sort(arr2);
		
		
		for(int i=0; i<arr1.length; i++) 
			System.out.println(arr1[i]);
		
		for(int i=0; i<arr2.length; i++) 
			System.out.println(arr2[i]);
	}
	
	public E[] sort(E[] arr) {
		for(int i = 0; i<arr.length; i++) {
			
			E min = arr[i];
			int min_i= i;
			//find min element
			for(int j = i; j<arr.length; j++) {
				if(arr[j].compareTo(min) < 0) {
					min = arr[j];
					min_i = j;
				}
			}
		
			//swap i with min_i
			arr[min_i] = arr[i];
			arr[i] = min;
		}
		
		return arr;
	}

}
