package fornite.util;

public class ForniteList<T> implements IForniteList<T> {

	private Object[] array;
	private int size;
	public ForniteList() {
		array = new Object[10];
		size = 0;
	}
	@Override
	public void add(T o)
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
	@Override
	public void remove(int i) throws IndexOutOfBoundsException
	{
		if(i<size)
		{
			for (int j = i; j < array.length-1; j++) {
				array[j] = array[j+1];
			}
			size--;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
		
	}
	@Override
	public T get(int i) throws IndexOutOfBoundsException
	{
		if(i<size)
		{
			return (T)array[i];
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}
	@Override
	public int size()
	{
		return size;
	}

}
