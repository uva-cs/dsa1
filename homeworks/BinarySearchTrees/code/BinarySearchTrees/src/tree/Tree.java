package tree;

/**
 * Generic interface for a tree data structure
 * @author Mark Floryan
 *
 */
public interface Tree<T extends Comparable<T>> {
	
	/**
	 * Inserts the given data into this tree
	 * @param data
	 */
	public void insert(T data);
	
	/**
	 * Returns true iff the given data is in this tree
	 * @param data
	 * @return
	 */
	public boolean find(T data);
	
	/**
	 * removes the given data from the tree, returns true iff the removal was successful
	 * @param data
	 * @return
	 */
	public void remove(T data);

}
