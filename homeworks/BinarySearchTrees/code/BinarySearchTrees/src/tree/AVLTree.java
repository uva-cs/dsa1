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
		curNode = super.insert(data, curNode);
		
		if(curNode == null) return null;
		
		//TODO: Update the height of curNode if necessary and call balance
		
		return curNode;
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing */
		curNode = super.remove(data,  curNode);
		
		if(curNode == null) return null;
		
		//TODO: Update the height of curNode if necessary and call balance
		
		return curNode;
	}
	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return the new root of this subtree
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		return null;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		return null
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		return null;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		return height(node.right) - height(node.left);
	}
	
	/* height method that checks for the null case */
	private int height(TreeNode<T> node) {
		if(node == null) return 0;
		return node.height;
	}
}
