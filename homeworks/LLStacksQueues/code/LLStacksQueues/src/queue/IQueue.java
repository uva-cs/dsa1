package queue;

/**
 * Interface for a generic queue. This will be implemented using a Linked-List
 * @author Mark Floryan
 *
 * @param <T>
 */
public interface IQueue<T> {

	/**
	 * Adds the given data to the back of the queue
	 * @param data
	 */
	public void enqueue(T data);
	
	/**
	 * Removes the data at the front of the queue and returns the removed value
	 * @return the data removed from the front of the queue
	 * @throws EmptyQueueException if attempting to dequeue from a queue of size 0
	 */
	public T dequeue();
	
	/**
	 * Returns the number of items currently in the queue
	 * @return the number of items in the queue
	 */
	public int size();
}
