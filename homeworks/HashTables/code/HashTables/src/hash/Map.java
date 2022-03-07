package hash;

/**
 * Interface for a generic key-value pair data-structure
 * @author Mark Floryan
 *
 * @param <K> The key
 * @param <V> The values
 */
public interface Map<K,V> {

	/**
	 * Insert the given key mapped to the given value
	 * @param key
	 * @param value
	 */
	public void insert(K key, V value);
	
	/**
	 * Return the value associated with the given key, null if none
	 * @param key
	 * @return
	 */
	public V retrieve(K key);
	
	/**
	 * return true iff this key is already mapped to a value
	 * @param key
	 * @return
	 */
	public boolean contains(K key);
	
	/**
	 * removes the value associated with the given key, if one exists
	 * @param key
	 */
	public void remove(K key);
}
