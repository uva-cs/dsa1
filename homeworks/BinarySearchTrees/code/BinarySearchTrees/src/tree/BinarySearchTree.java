package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, root);
	}
	
	/**
	 * Helper method for inserting recursively
	 * @param data
	 * @param curNode
	 * @return a reference to the new root of the subtree
	 */
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		return null;
	}

	@Override
	public boolean find(T data) {
		return find(data, root);
	}
	
	private boolean find(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		return false;
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, root);
	}
	
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		return null;
	}
}
