package tree;

/**
 * Simple BST Node. Contains the data in this node, and pointers to left and right children
 * @author Mark Floryan
 *
 * @param <T>
 */
public class TreeNode<T>{
		protected TreeNode<T> left = null;
		protected TreeNode<T> right = null;
		protected int height = 0;
		protected T data = null;
		
		public TreeNode(T data) {
			this.data = data;
		}
		
		public TreeNode(T data, int height) {
			this(data);
			this.height = height;
		}
}
