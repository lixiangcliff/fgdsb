package Convert_BST_to_Sorted_Doubly_Linked_List;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a binary search tree, convert it to a sorted doubly-linked list.
	 * Your solution must be in-place without altering the nodes' values.
	 * 
	 * For example:
	 * Input:
		   2
		  / \
		 1   3
		Output:
		   1
		   \\
		    2
		     \\
		      3
		Note: Since there is no doubly linked list structure here, 
		you have to to use TreeNode to represent a doubly-linked list node, 
		i.e. use left as previous and right as next.
	 */
	
    //refer to leetcode: iterative way in "Binary_Tree_Inorder_Traversal" 
    public TreeNode bst_to_list(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dummy = new TreeNode(0);
        TreeNode pre = dummy;
        LinkedList<TreeNode> s = new LinkedList<TreeNode>();
        TreeNode node = root; //
        while (true) {
            while (node != null) { //
                s.push(node);
                node = node.left; //
            }
            if (s.isEmpty()) { // 
                break;
            }
            node = s.pop(); // 
            //only difference
            node.left = pre;
            pre.right = node;
            pre = node;
            //difference done; // 
            node = node.right; // 
        }
        dummy.right.left = null;
        return dummy.right;
    }
	
	

}


class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int x) { val = x; }
}