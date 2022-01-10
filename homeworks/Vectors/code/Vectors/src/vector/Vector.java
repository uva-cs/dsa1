package vector;

public class Vector<T> implements List<T> {
	
	private T[] data;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	
	public Vector(){
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.data = (T[])new Object[capacity];
		this.size = 0;
	}
	
	public int capacity() {
		return this.data.length;
	}

	/**
	 * When the underlying array fills up, we need to resize it to accommodate the stack's elements
	 * Ignores the request if the new capacity is too small to fit the elements already in the stack
	 */
	public void resize(int newCapacity){
		//TODO: Implement this method
	}

	@Override
	public int size() {
		//TODO: Implement this method
	}

	@Override
	public void clear() {
		//TODO: Implement this method
	}

	@Override
	public void insertAtTail(T data) {
		//TODO: Implement this method
	}

	@Override
	public void insertAtHead(T data) {
		//TODO: Implement this method
	}

	@Override
	public void insertAt(int index, T data) {
		//TODO: Implement this method
	}

	@Override
	public T removeAtTail() {
		//TODO: Implement this method
		return null;
	}

	@Override
	public T removeAtHead() {
		//TODO: Implement this method
		return null;
	}

	@Override
	public int find(T data) {
		//TODO: Implement this method
	}

	@Override
	public T get(int index) {
		//TODO: Implement this method
	}

}
