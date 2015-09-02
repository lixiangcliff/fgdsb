package Lowest_Common_Ancestor_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Follow up for "Lowest Common Ancestor":
	 * How if the given binary tree are binary search tree?
	 */
	
    public TreeNode lca(TreeNode root, int m, int n) {
    	if (m > n) {
    		int tmp = m;
    		m = n;
    		n = tmp;
    	}
    	while (true) {
    		if (root == null) {
    			return null;
    		}
    		if (m <= root.val && root.val <= n) {
    			return root;
    		} else if (root.val < m) {
    			root = root.right;
    		} else {
    			root = root.left;
    		}
    	}
    }

}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int x) { val = x; }
}