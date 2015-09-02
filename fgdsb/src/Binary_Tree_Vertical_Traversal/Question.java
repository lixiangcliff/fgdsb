package Binary_Tree_Vertical_Traversal;

import java.util.ArrayList;
import java.util.List;



public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		Question q = new Question();
		t5.left = t2;
		t5.right = t7;
		t2.left = t1;
		t2.right = t3;
		t7.left = t6;
		t7.right = t8;
		t3.right = t4;
		t8.right = t9;
		TreeNode root = t5;
		List<List<Integer>> res = q.vertical_traversal(root);
		for (List<Integer> item : res) {
			for (int num : item) {
				System.out.print(num + ", ");
			}
			System.out.println("");
		}
		
	}
	
	/**
	 * Given a binary tree, traverse it vertically.
	 * For example:
			
			     5 
			   /   \
			  2     7
			 / \   / \
			1   3 6   8
			     \     \
			      4     9
			Should return as:
			
			[
			  [1],
			  [2],
			  [5, 3, 6],
			  [4, 7],
			  [8],
			  [9]
			]
	 */
	
	//手写的test case没有问题
	//http://www.fgdsb.com/2015/01/03/print-binary-tree-vertically/
	//http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
    public List<List<Integer>> vertical_traversal(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	int[] min_max = {0, 0};
    	int curDist = 0;
    	findMin_Max(root, min_max, curDist);
    	int min = min_max[0];
    	int max = min_max[1];
    	int size = max - min + 1;
    	for (int i = 0; i < size; i++) {
    		res.add(new ArrayList<Integer>());
    	}
    	curDist = Math.abs(min);
    	assignNode(res, root, curDist);
    	return res;
    }
    
    private void assignNode(List<List<Integer>> res, TreeNode root, int curDist) {
    	if (root == null) {
    		return;
    	}
    	res.get(curDist).add(root.val);
    	assignNode(res, root.left, curDist - 1);
    	assignNode(res, root.right, curDist + 1);
    }
    
    private void findMin_Max(TreeNode root, int[] min_max, int curDist) {
    	if (root == null) { //base case
    		return;
    	}
    	if (curDist < min_max[0]) {
    		min_max[0] = curDist;
    	} else if (curDist > min_max[1]) {
    		min_max[1] = curDist;
    	}
    	findMin_Max(root.left, min_max, curDist - 1);
    	findMin_Max(root.right, min_max, curDist + 1);
    }
	
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int x) { val = x; }
}
