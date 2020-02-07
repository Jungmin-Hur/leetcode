package sample;

import common.Sample;

/**
 * 669. Trim a Binary Search Tree
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree,
 * so the result should return the new root of the trimmed binary search tree.
 */
@Sample
public class TrimABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if(root == null) return root;

        //R보다 크면 R이후는 자른다.
        if(root.val > R) return trimBST(root.left, L, R);
        //L보다 작으면 L이전은 자른다.
        if(root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
