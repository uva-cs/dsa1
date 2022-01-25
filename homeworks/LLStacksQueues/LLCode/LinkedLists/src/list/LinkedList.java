package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		//TODO: Write this method
	}
	
	public int size() {
		//TODO: Write this method
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		//TODO: Write this method
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		//TODO: Write this method
	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		//TODO: Write this method
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		//TODO: Write this method
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		//TODO: Write this method
	}
	
	
	
	public T removeAtTail(){
		//TODO: Write this method
		return null;
	}
	
	public T removeAtHead(){
		//TODO: Write this method
		return null;
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		//TODO: Write this method
		return null;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		//TODO: Write this method
		return null;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		//TODO: Write this method
		return null;
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){
		//TODO: Write this method
		return null;
	}
	public ListIterator<T> back(){
		//TODO: Write this method
		return null;
	}
	
	
}
