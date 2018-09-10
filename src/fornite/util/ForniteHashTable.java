package fornite.util;

import java.util.Hashtable;

import model.Player;

public class ForniteHashTable<K, E>{

	private Object[] array;
	private int size;
	public ForniteHashTable()
	{
		array = new Object[10];
		size = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = new ForniteList<FornitePair<K, E>>();
		}
	}
	
	public int hash(K key)
	{
		return key.hashCode();
	}
	
	public void put(K key, E item)
	{
		int index = hash(key)%10;
		ForniteList<E> f = (ForniteList<E>)array[index];
		FornitePair<K, E> i = new FornitePair<K, E>(key, item);
		f.add((E) i);
		size++;
	}
	
	public E get(K key)
	{
		E ret = null;
		ForniteList<E> list = (ForniteList<E>)array[key.hashCode()%10];
		for (int i = 0; i < list.size(); i++) {
			FornitePair<K, E> p = (FornitePair<K, E>)list.get(i);
			if(p.getKey().equals(key))
			{
				ret = p.getValue();
			}
		}
		return ret;
	}
	
	public void remove(K key)
	{
		ForniteList<E> list = (ForniteList<E>)array[key.hashCode()%10];
		for (int i = 0; i < list.size(); i++) {
			FornitePair<K, E> p = (FornitePair<K, E>)list.get(i);
			if(p.getKey().equals(key))
			{
				list.remove(i);
			}
		}
	}
	
	public int size()
	{
		return size;
	}
}
