package fornite.util;

public class ForniteQueue<E> {
	
	private ForniteNode<E> first;
	private ForniteNode<E> last;

	public ForniteQueue() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return last == null;
	}
	
	public void enqueue(Object item) {
		ForniteNode newNode = new ForniteNode(item);
		if (isEmpty( )) { 
		first = newNode;} 
		else {last.setNext(newNode);} 
		last = newNode;
	}
	
	public Object dequeue( ) throws QueueException{
		if (!isEmpty( )) {
		ForniteNode firstNode = first;
		if (first == last) {last = null;}
		else{first = first.getNext( );}
		return firstNode.getItem( ); }
		else{throw new QueueException("QueueException on dequeue: empty");}
		}
	
	public Object front( ) throws QueueException {
		if (!isEmpty( )) {
		// queue is not empty. Retrieve the front item;
		return first.getItem( );
		}
		else {throw new QueueException("QueueException on front: queue empty");}
		}
}
