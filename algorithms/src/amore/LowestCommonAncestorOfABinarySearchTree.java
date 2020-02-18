/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
package amore;

import common.A;

@A
public class LowestCommonAncestorOfABinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val > p.val && curr.val < q.val ||
                    curr.val < p.val && curr.val > q.val) return curr;
            if(curr.val == p.val) return p;
            if(curr.val == q.val) return q;

            if(curr.val > p.val) curr = curr.left;
            else curr = curr.right;
        }

        return null;
    }
}
