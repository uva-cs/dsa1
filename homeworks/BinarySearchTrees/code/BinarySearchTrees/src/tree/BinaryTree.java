package tree;


public class BinaryTree<T> {

	protected TreeNode<T> root = null;
	
	/* Traversal methods */
	public String getInOrder() {
		return getInOrder(root);
	}
	private String getInOrder(TreeNode<T> curNode) {
		//TODO: return the in order traversal of this tree, space separated
	}
	
	public String getPreOrder() {
		return getPreOrder(root);
	}
	private String getPreOrder(TreeNode<T> curNode) {
		//TODO: return the pre order traversal of this tree, space separated
	}
	
	public String getPostOrder() {
		return getPostOrder(root);
	}
	private String getPostOrder(TreeNode<T> curNode) {
		//TODO: return the post order traversal of this tree, space separated
	}

	//------------------------------------------------------------------------
	//EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
	//YOU SHOULD STILL LOOK AT THIS CODE
	//------------------------------------------------------------------------
	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	//TODO: Look at these methods and think about how they might be useful for this assignment
	public int height() {
		return height(root);
	}
	
	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return 0;
		return node.height;
	}
}
