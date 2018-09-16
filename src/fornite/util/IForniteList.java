package fornite.util;

public interface IForniteList<T> {

	public void add(T o);
	
	public void remove(int i);
	
	public T get(int i);
	
	public int size();
}
