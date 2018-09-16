package fornite.util;

import java.util.Hashtable;

import model.Player;

public class ForniteHashTable<K, E> implements IForniteHashTable<K, E>{

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
	
	@Override
	public void put(K key, E item)
	{
		int index = (key.hashCode())%10;
		ForniteList<E> f = (ForniteList<E>)array[index];
		FornitePair<K, E> i = new FornitePair<K, E>(key, item);
		f.add((E) i);
		size++;
	}
	@Override
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
	@Override
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
		size--;
	}
	@Override
	public int size()
	{
		return size;
	}
	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}
}
