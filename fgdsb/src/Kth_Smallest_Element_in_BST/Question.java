package Kth_Smallest_Element_in_BST;

import java.util.LinkedList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t2.left = t1;
		t2.right = t3;
		System.out.print(q.kth_smallest(t2, 3).val);

	}
	
	/**
	 * Given a binary search tree and an integer K, find K-th smallest element in BST.
	 * For example: 
		Input:
		
		   2
		  / \
		 1   3
		 
		K = 2
		
		Output:
		2
		
		Note: Your solution must be in-place without altering the nodes' values.
	 */
	
	//same as leetcode: Binary_Tree_Inorder_Traversal
    public TreeNode kth_smallest(TreeNode root, int k) {
    	if (root == null) {
    		return null;
    	}
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	int count = 1;
    	TreeNode node = root;
    	while (true) {
    		while (node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		if (stack.isEmpty()) {
    			break;
    		}
    		node = stack.pop();
    		if (count == k) {
    			return node;
    		} else {
    			count++;
    		}
    		node = node.right;
    	}
    	return null;
    }

}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int x) { val = x; }
}
