package forniteUtil;

public class ForniteStack<T> {

	private Object[] array;
	private int size;
	public ForniteStack() {
		array = new Object[10];
		size = 0;
	}
	
	public void push(T o)
	{
		if(size==array.length)
		{
			Object[] a = new Object[size+10];
			for (int i = 0; i < array.length; i++) {
				a[i] = array[i];
			}
			array = a;
		}
		array[size] = (Object)o;
		size++;
	}
	
	public void pop() throws IndexOutOfBoundsException
	{
		if(!isEmpty())
		{
			array[size-1] = null;
			size--;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public boolean isEmpty()
	{
		boolean empty = false;
		if(size==0)
		{
			empty = true;
		}
		return empty;
	}
	
	public T top()
	{
		return (T)array[size-1];
	}
}
