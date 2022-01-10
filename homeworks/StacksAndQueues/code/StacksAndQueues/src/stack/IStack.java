package stack;

/**
 * Interface for a generic stack. This will be implemented using an array
 * @author Mark Floryan
 *
 * @param <T>
 */
public interface IStack<T> {

	
	public void push(T data);
	
	public T pop();
	
	public int size();
	public int capacity();
	
	public void resize(int newCapacity); 
}
