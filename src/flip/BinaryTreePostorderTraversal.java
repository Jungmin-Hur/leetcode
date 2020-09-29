/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
package flip;

import common.Flip;

import java.util.ArrayList;
import java.util.List;

@Flip
public class BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    postorder(root, res);

    return res;
}
    public void postorder(TreeNode root, List<Integer> res) {
        if(root != null) {
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }

}
