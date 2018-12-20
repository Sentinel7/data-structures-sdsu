
public interface HeapI<E> {
	public void add(E obj);
	public E remove();
	public void swap(int a, int b);
	public void trickleUp(int position);
	public void trickleDown(int parent);
}
