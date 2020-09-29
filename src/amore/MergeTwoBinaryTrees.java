/**
 * 617. Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
package amore;

import common.A;

@A
public class MergeTwoBinaryTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root;

        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
