
public class Heap<E> implements HeapI<E> {
	
	int lastposition;
	int heapSize;
	E[] arr;
	
	public Heap(int heapSize) { // Constructor
		this.lastposition = 0;
		this.heapSize = heapSize;
		this.arr = (E[]) new Object[heapSize];
	}
	
	// Add element to last position, then trickle up
	public void add(E obj) {
		arr[lastposition++] = obj;
		trickleUp(lastposition);
	}
	
	// Remove the root element and replace with last element, then trickle down
	public E remove() {
		E tmp = arr[0];
		swap(0, lastposition--);
		trickleDown(0);
		return tmp;
	}
	
	public void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
	
	// If the element is larger than its parent (in a max heap), swap them and continue (recursive).
	public void trickleUp(int position) {
		if (position == 0)
			return;
		
		int parent = (int) Math.floor((position-1)/2);
		if (((Comparable<E>) arr[position]).compareTo(arr[parent]) > 0) {
			swap(position, parent);
			trickleUp(parent);
		}
	}
	
	// If the parent is smaller than children (in a max heap), swap the parent with the larger child and continue (recursive).
	public void trickleDown(int parent) {
		int left = (2*parent)+1;
		int right = (2*parent)+2;
		
		if (left == lastposition && (((Comparable<E>)arr[parent]).compareTo(arr[left]) < 0)) {
			swap(parent, left);
			return;
		}
		if (right == lastposition && (((Comparable<E>)arr[parent]).compareTo(arr[right]) < 0)) {
			swap(parent, right);
			return;
		}
		if (left >= lastposition || right >= lastposition) {
			return;
		}
		if ((((Comparable<E>)arr[left]).compareTo(arr[right]) > 0) && (((Comparable<E>)arr[parent]).compareTo(arr[left]) < 0)) {
			swap(parent, left);
			trickleDown(left);
		}
		else if (((Comparable<E>)arr[parent]).compareTo(arr[right]) < 0) {
			swap(parent, right);
			trickleDown(right);
		}
	}
	
}
