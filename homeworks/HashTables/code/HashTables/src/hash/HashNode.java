package hash;

public class HashNode<K,V> {

	private K key;
	private V value;
	
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		return this.key.equals(((HashNode<K,V>)other).key);
	}
	
	public K getKey() {return this.key;}
	public V getValue() {return this.value;}
	public void setValue(V newValue) { this.value = newValue; }
}
