package fornite.util;

public class ForniteNode<E> {
	
	private ForniteNode<E> next;
	private Object item;
	
	public ForniteNode(Object item) {
		this.item = item;
	}
	
	public ForniteNode<E> getNext() {
		return next;
	}
	public void setNext(ForniteNode<E> next) {
		this.next = next;
	}
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	
	
	
	
}
