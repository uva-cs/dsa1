package hash;


/**
 * Hash Table implementation. Uses linear probing to resolve collisions.
 * @author Mark Floryan
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements Map<K,V>{

	/* The array of objects and related things */
	private HashNode<K,V>[] table;
	
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	
	
	public HashTable() {
		this(INITIAL_CAP);
	}
	
	public HashTable(int initialCapacity) {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	@Override
	public void insert(K key, V value) {
		/* TODO: IMPLEMENT THIS METHOD */
	}

	@Override
	public V retrieve(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
	}

	@Override
	public boolean contains(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
	}

	@Override
	public void remove(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	
}
