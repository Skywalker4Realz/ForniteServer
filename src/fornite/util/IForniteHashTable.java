package fornite.util;

public interface IForniteHashTable<K, E> {

	public void put(K key, E item);
	
	public E get(K key);
	
	public void remove(K key);
	
	public int size();
	
	public boolean isEmpty();
}
