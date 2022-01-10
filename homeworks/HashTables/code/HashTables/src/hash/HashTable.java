package hash;

/**
 * Hash Table implementation.
 *
 */
public class HashTable<K,V> implements Map<K,V>{

	private static final int INITIAL_CAPACITY = 100;
	private int size = 0;
	
	/* Max allowed load factor */
	private double maxLoad = 0.75;
	
	/* Sentinel value for removes */
	private HashNode<K,V> sentinel = new HashNode<K,V>(null, null);
	
	public HashTable() {
		this(INITIAL_CAP);
	}
	
	public HashTable(int initialCapacity) {
		//TODO: Write this method
	}
	
	@Override
	public void insert(K key, V value) {
		//TODO: Write this method
	}

	@Override
	public V retrieve(K key) {
		//TODO: Write this method
	}

	@Override
	public boolean contains(K key) {
		//TODO: Write this method
	}

	@Override
	public void remove(K key) {
		//TODO: Write this method
	}
	
	private void resize() {
		//TODO: Write this method
	}

	/**
	 * Getting and setting the maxLoad field
	 * @return
	 */
	public double getMaxLoad() {return maxLoad;}
	public void setMaxLoad(double maxLoad) {this.maxLoad = maxLoad;}
	

}
