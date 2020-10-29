/**
 * 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/solution/
 */
package amore;

import common.A;

//개선필요함!!!
@A
public class ConstructStringFromBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        return search(t);
    }

    public String search(TreeNode t) {
        if(t == null) return "";
        if(t.left == null && t.right == null) return String.valueOf(t.val);
        if(t.right == null) return t.val + "(" + search(t.left) + ")";
        return t.val + "(" + search(t.left) + ")(" + search(t.right) + ")";
    }
}
