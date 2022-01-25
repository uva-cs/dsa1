package list;

public interface List<T> {
	
	/**
	 * Returns the size of this list, i.e., the number of nodes currently between the head and tail
	 * @return
	 */
	public int size();
	
	/**
	 * Clears out the entire list
	 */
	public void clear() ;
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data);
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data);
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data);
	
	/**
	 * Remove at tail and head respectively
	 * @return
	 */
	public T removeAtTail();
	public T removeAtHead();
	
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data);
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index);
	
}
