package stack;

/**
 * A Linked-List based Queue
 * @author Mark Floryan
 *
 * @param <T>
 */
public class Stack<T> implements IStack<T>{

	private T[] data;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	
	public Stack(){
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		//TODO: Implement this method
	}

	
	public void push(T data) {
		//TODO: Implement this method
	}

	public T pop(){
		//TODO: Implement this method
		return null;
	}

	/**
	 * Returns the size of this Stack
	 */
	public int size() {
		//TODO: Implement this method
		return 0;
	}
	
	public int capacity() {
		//TODO: Implement this method
		return 0;
	}

	/**
	 * When the underlying array fills up, we need to resize it to accommodate the stack's elements
	 * Ignores the request if the new capacity is too small to fit the elements already in the stack
	 */
	public void resize(int newCapacity){
		//TODO: Implement this method
	}
	
	
}
