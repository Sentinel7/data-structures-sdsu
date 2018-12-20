
public interface ListI<E> {
	public void addFirst(E obj);		
	public void addLast(E obj);
	public E removeFirst();
	public E removeLast();		
	public E remove(E obj);
	public boolean contains(E obj);
}
