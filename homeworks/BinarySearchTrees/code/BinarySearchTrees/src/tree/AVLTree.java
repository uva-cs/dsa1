package tree;

/**
 * Self-balancing AVL Tree
 * @author Mark Floryan
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		return null;
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		return null;
	}
	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		return null;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		return null;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		return null;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		//TODO: Implement this method
		return 0;
	}
	
	
}
