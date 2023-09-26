import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solution(list, root);

        return list;
    }

    public void solution(List list, TreeNode root) {
        if(root != null) {//자식이 있으면
            solution(list, root.left);
            list.add(root.val);
            solution(list, root.right);
        }
    }
}

