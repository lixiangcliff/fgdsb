package Lowest_Common_Ancestor;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given an arbitrary binary tree and two values, write a function to find the lowest common ancestor.
	 */
	
	//same as lintcode: Lowest_Common_Ancestor
    public TreeNode lca(TreeNode root, int m, int n) {
    	if (root == null || root.val == m || root.val == n) { // 
    		return root;
    	}
    	//divide
    	TreeNode left = lca(root.left, m, n);
    	TreeNode right = lca(root.right, m, n);
    	//conquer
    	if (left != null && right != null) { //
    		return root;
    	}
    	if (left != null) { //
    		return left;
    	}
    	if (right != null) { //
    		return right;
    	} 
    	return null; // 
    }

}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int x) { val = x; }
}
