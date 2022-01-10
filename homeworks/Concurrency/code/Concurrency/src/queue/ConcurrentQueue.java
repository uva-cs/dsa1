package queue;

/**
 * A Linked-List based Queue
 * Is concurrent (i.e., can modify front and back in parallel)
 *
 * @param <T>
 */
public class ConcurrentQueue<T> implements IQueue<T>{

	
	/**
	 * Constructor: Initialize the inner list
	 */
	public ConcurrentQueue(){
		//TODO: Write this method
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		//TODO: Write this method
	}
	

	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		
		//TODO: Write this method
	}
	
	/**
	 * Simply remove data from the head of the list
	 */
	public T dequeue(){	
		
		//TODO: Write this method
	}
	
	
}
