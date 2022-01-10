package tree;

public class BinaryTree<T> {

	protected TreeNode<T> root = null;
	
	/* Print methods */
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(TreeNode<T> curNode) {
		//TODO: Implement this method
	}
	
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}
	private void printPreOrder(TreeNode<T> curNode) {
		//TODO: Implement this method
	}
	
	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}
	private void printPostOrder(TreeNode<T> curNode) {
		//TODO: Implement this method
	}

	/* CODE BELOW IS IMPLEMENTED FOR YOU */
	
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
	
	/* Computes the height of the tree on the fly */
	public int height() {
		return height(root);
	}
	private int height(TreeNode<T> curNode) {
		if(curNode == null) return 0;
		else return Math.max(height(curNode.left), height(curNode.right))+1;
	}
}
