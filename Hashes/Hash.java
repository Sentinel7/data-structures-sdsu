import java.util.*;

public class Hash<K, V> implements HashI<K, V> {

	int numElements, tableSize;
	double maxLoadFactor;
	LinkedList<HashElement<K, V>>[] hArr;

	class HashElement<K, V> implements Comparable<HashElement<K, V>> { //Create the HashElement inner class
		K key;
		V value;

		public HashElement(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public int compareTo(HashElement<K, V> obj) {
			return (((Comparable<K>) this.key).compareTo(obj.key));
		}
	}

	public Hash(int tableSize) { //Constuctor

		this.tableSize = tableSize;
		this.hArr = (LinkedList<HashElement<K, V>>[]) new LinkedList[tableSize];

		for (int i = 0; i < tableSize; i++)
			this.hArr[i] = new LinkedList<HashElement<K, V>>();

		this.maxLoadFactor = 0.75;
		this.numElements = 0;
	}

	// This function adds elements to the hash.
	// To add an element, however, we need to get a special key in order to avoid collisions.
	// First, we need to get use the hashCode() method to produce a special integer value for our key.
	// Second, since this int could be negative, we need to use the & 0x7FFFFFFF hexadecimal to turn it positive.
	// Third, since this int could be larger than the size of the array, we just mod it by the tableSize.
	public boolean add(K key, V value) {

		if (loadFactor() > maxLoadFactor)
			resize(tableSize * 2);

		HashElement<K, V> ne = new HashElement(key, value);

		// Procedure to find special key
		int hashVal = key.hashCode();
		hashVal = hashVal & 0x7FFFFFFF;
		hashVal = hashVal % tableSize;	

		hArr[hashVal].addFirst(ne);
		numElements++;
		return true;
	}

	private double loadFactor() { //the ratio of number of elements to hash table size
		return (numElements / tableSize);
	}

	public boolean remove(K key) { //removes element at the key

		int hashVal = key.hashCode();
		hashVal = hashVal & 0x7FFFFFFF;
		hashVal = hashVal % tableSize;

		hArr[hashVal].removeFirst();
		numElements--;
		return true;
	}

	public V getValue(K key) { //gets value of element at the key

		int hashVal = (key.hashCode() & 0x7FFFFFFF) % tableSize;

		for (HashElement<K, V> e : hArr[hashVal]) {
			if (((Comparable<K>) key).compareTo(e.key) == 0)
				return e.value;
		}
		return null;
	}

	public void resize(int newSize) { //resizes the current hash array of linked lists if it is getting full 

		LinkedList<HashElement<K, V>>[] newArr = (LinkedList<HashElement<K, V>>[]) new LinkedList[newSize];

		for (int i = 0; i < newSize; i++)
			newArr[i] = new LinkedList<HashElement<K, V>>();

		for (LinkedList<HashElement<K, V>> el : this.hArr) {
			for (HashElement<K, V> x : el) {
				K key = x.key;

				V val = getValue(key);
				HashElement<K, V> ne = new HashElement(key, val);

				int hashVal = (key.hashCode() & 0x7FFFFFFF) % newSize;
				newArr[hashVal].addFirst(ne);
			}
		}
		hArr = newArr;
		tableSize = newSize;
	}

	// This IteratorHelper inner class is used as a way to iterate through all
	// of the elements in the Chain Hash data structure.
	// There are two versions I have implemented. The first version puts the
	// keys of all the elements
	// into one array, and THEN iterates through them (instructor-made version).
	// I thought of a more efficient way to implement the same class. Instead of
	// loading all the keys into one array and then iterating through,
	// just iterate through the hash while getting the keys.

	class IteratorHelper<T> implements Iterator<T> {

		T[] keys = (T[]) new Object[numElements];
		int position;

		public IteratorHelper() {

			int p = 0;
			for (int i = 0; i < tableSize; i++) {
				LinkedList<HashElement<K, V>> list = hArr[i];

				for (HashElement<K, V> h : list)
					keys[p++] = (T) h.key;
			}
			position = 0;
		}

		public boolean hasNext() {
			return position < keys.length;
		}

		public T next() {
			if (!hasNext())
				return null;
			return keys[position++];
		}
	}

	class IteratorHelper2<T> implements Iterator<T> {

		int position = 0; // in the array
		int position_in_list = 0; // in each linkedlist

		public boolean hasNext() {

			if (position < hArr.length)
				if (position_in_list < hArr[position].size())
					return true;

			return false;
		}

		public T next() {
			if (!hasNext())
				return null;

			T result = (T) hArr[position].get(position_in_list);

			// Advance
			if (position_in_list < hArr[position].size())
				position_in_list++;
			else { // go to next list
				position++;
				position_in_list = 0;
			}

			return result;
		}
	}

}
