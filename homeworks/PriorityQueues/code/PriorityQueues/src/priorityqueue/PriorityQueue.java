package priorityqueue;

/**
 * A simple interface for a priority queue
 *
 */
public interface PriorityQueue<T extends Comparable<T>> {
	
	/**
	 * Inserts the given data into the queue with the 
	 * given priority value
	 * @param data
	 * @param priority
	 */
	public void push(T data);
	
	/**
	 * Deletes the item in the queue that has the 
	 * most priority. 
	 */
	public T poll();
	
	/**
	 * Returns the element in the queue with the most
	 * priority (i.e., the next element to be deleted)
	 * @return
	 */
	public T peek();
	
	/**
	 * Returns the number of elements in the queue
	 * @return
	 */
	public int size();
	
}
