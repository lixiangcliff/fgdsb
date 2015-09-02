package All_Path_From_Root_to_Leaf;

import java.util.ArrayList;
import java.util.List;

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
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		List<List<Integer>> res = q.all_path(t1);
		for (List<Integer> item : res) {
			for (int num : item) {
				System.out.print(num + ", ");
			}
			System.out.println("");
		}

	}
	
	/**
	 * Return all path from root to leaf.
	 * For example:
	 * Input:

		   1
		  / \
		 2   3
		    /
		   4
		Output:
		[1, 2]
		[1, 3, 4]
	 */
	
	
	//backtracking
    public List<List<Integer>> all_path(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> item = new ArrayList<Integer>();
    	helper(res, item, root);
    	return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> item, TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null) {
    		item.add(root.val);
    		res.add(new ArrayList<Integer>(item));
    		item.remove(item.size() - 1);
    		return;
    	}
    	item.add(root.val);
		helper(res, item, root.left);
		helper(res, item, root.right);
    	item.remove(item.size() - 1);
    }
    

}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int x) { val = x; }
}
