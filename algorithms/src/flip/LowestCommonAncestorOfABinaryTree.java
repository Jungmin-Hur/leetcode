/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
package flip;

import common.Flip;

@Flip
public class LowestCommonAncestorOfABinaryTree {
    // [3,5,1,6,2,0,8,null,null,7,4]
    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;

        TreeNode res = lowestCommonAncestor(t1, t2, t9);
        System.out.println(res.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static int index = 1;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 가장아래까지 가거나 p, q까지 도달
        if(root == null) {
//            System.out.println("root == null: " + index++);
            return root;
        }
        if(root == p || root == q) {
//            System.out.println("root == p || root == q : "  + root.val + " : " + index++);
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            //left가 null이라면 right 하위에 나머지 노드가 존재하는 것
//            System.out.println("left:" + root.val + " : " + index++);
            return right;
        }
        else if(right == null) {
            //right가 null이라면 left 하위에 나머지 노드가 존재하는 것임
//            System.out.println("right:" + root.val + " : " + index++);
            return left;
        }

        return root; //left와 right가 모두 존재한다는 것은 서로 다른 루트에 존재하는 노드라는 뜻
    }
}
