package list;

public class ListIterator<T> {
	
	protected ListNode<T> curNode;
	
	public ListIterator(ListNode<T> curNode) {
		//TODO: Write this method
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() {
		//TODO: Write this method
		return false;
	}
	
	public boolean isPastBeginning() {
		//TODO: Write this method
		return false;
	}
	
	/**
	 * Get the data at the current iterator position
	 */
	public T value() {
		//TODO: Write this method
		return null;
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() {
		//TODO: Write this method
	}
	
	public void moveBackward() {
		//TODO: Write this method
	}
}
