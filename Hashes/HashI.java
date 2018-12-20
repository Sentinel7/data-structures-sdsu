
public interface HashI<K, V> {
	public boolean add(K key, V value);
	public boolean remove(K key);
	public V getValue(K key);
	public void resize(int newSize);
}
