package forniteUtil;

public class Pair<K, E> {

	private K key;
	private E value;
	public Pair(K k, E e) {
		key = k;
		value = e;
	}
	public K getKey() {
		return key;
	}
	public E getValue() {
		return value;
	}

}
