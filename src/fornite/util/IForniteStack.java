package fornite.util;

public interface IForniteStack<T> {

	public void push(T o);
	
	public void pop();
	
	public boolean isEmpty();
	
	public T top();
	
	public int size();
}
