/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
package flip;

import common.Flip;

@Flip
public class LowestCommonAncestorOfABinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 가장아래까지 가거나 p, q까지 도달
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) //left가 null이라면 right 하위에 나머지 노드가 존재하는 것임
            return right;
        else if(right == null) //right가 null이라면 left 하위에 나머지 노드가 존재하는 것임
            return left;

        return root; //left와 right가 모두 존재한다는 것은 서로 다른 루트에 존재하는 노드라는 뜻
    }
}
