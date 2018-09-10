package fornite.util;

public class FornitePair<K, E> {

	private K key;
	private E value;
	public FornitePair(K k, E e) {
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
