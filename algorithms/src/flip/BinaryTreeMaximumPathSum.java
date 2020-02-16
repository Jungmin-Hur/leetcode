/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
package flip;

import common.Flip;

@Flip
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        getMax(root);
        return max;
    }

    public int getMax(TreeNode root) {
        if(root == null) return 0;
        //왼쪽에서 찾은 값이 0보다 작으면 0처리 -> 만약에 0보다 작으면 사용하지 않는 다는 뜻
        int leftVal = Math.max(getMax(root.left),0);
        int rightVal = Math.max(getMax(root.right),0);
        if(leftVal + rightVal + root.val > max) max = leftVal + rightVal + root.val;
        return Math.max(leftVal, rightVal) + root.val;
    }
}
