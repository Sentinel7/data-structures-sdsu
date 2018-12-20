import java.util.*;

public class MyLinkedList<E> implements ListI<E> {

	class Node<E> {
		E data;
		Node<E> next;
		
		public Node(E obj) {
			data = obj;
			next = null;
		}
	}
	
	class IteratorHelper implements Iterator<E> {
		Node<E> index;
		public IteratorHelper() {
			index = head;
		}
		public boolean hasNext() {
			return (index != null);
		}
		public E next() {
			if (!hasNext()) 
				throw new NoSuchElementException();
			E val = index.data;
			index = index.next;
			return val;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int currentSize;
	
	public MyLinkedList() {
		head = null;
		tail = null;
		currentSize = 0;
	}
	
	public void addFirst(E obj) {
		if(head == null)
			addLast(obj);
			
		Node<E> node = new Node<E>(obj);
		
		node.next = head;
		head = node;
		currentSize++;
	}
	
	public void addLast(E obj) {
		Node<E> node = new Node<E>(obj);
		
		if (head == null) {
			head = tail = node;
			currentSize++;
			return;
		}
		tail.next = node;
		tail = node;
		currentSize++;
	}
	
	public E removeFirst() {
		if (head == null)
			return null;
		
		E tmp = head.data;
		if (head == tail)
			head = tail = null;
		else
			head = head.next;
		
		return tmp;
	}
	
	public E removeLast() {
		if (head == null)
			return null;
		if (head == tail)
			return removeFirst();
		
		Node<E> current = head;
		Node<E> previous = null;
		
		while (current != tail) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		tail = previous;
		currentSize--;
		return current.data;
	}
	
	public E remove(E obj) {
		Node<E> current = head;
		Node<E> previous = null;
		
		while (current != null) {
			if (((Comparable<E>)current.data).compareTo(obj) == 0) {
				if (current == head)
					return removeFirst();
				currentSize--;
				previous.next = current.next;
				return current.data;
			}
			previous = current;
			current = current.next;
		}
		return null;
	}
	
	public boolean contains(E obj) {
		Node<E> current = head;
		
		while (current != null) {
			if (((Comparable<E>)current.data).compareTo(obj) == 0) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
}
