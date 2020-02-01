package acomp; /**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 */

import common.Acomp;

import java.util.HashSet;

/**
 * Definition for a binary tree node.
 */
@Acomp
public class SubtreeOfAnotherTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Approach #1 Using Preorder Traversal
    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     String tree1 = preorder(s, true);
    //     String tree2 = preorder(t, true);
    //     System.out.println(tree1);
    //     System.out.println(tree2);
    //     return tree1.indexOf(tree2) >= 0;
    // }

    HashSet<String> trees = new HashSet <> ();

    //트리를 모두 조회해서 String으로 트리 구조 자체를 만들어주고, 이를 비교한다.
    public static String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        // System.out.println("#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false));
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
        //왼쪽으로 돌기, 오른쪽으로 돌기
    }

    //Approach #2 By Comparison of Nodes
    //TODO study recursive....
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public static boolean equals(TreeNode x,TreeNode y) {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }

    public static boolean traverse(TreeNode s,TreeNode t) {
        return s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public static void main(String args[]) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(3);
        TreeNode t14 = new TreeNode(4);
        TreeNode t15 = new TreeNode(5);
        t13.left = t14;
        t13.right = t15;
        t14.left = t11;
        t15.right = t12;

        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t24 = new TreeNode(4);

        t24.left = t21;
        t24.right = t22;

        System.out.println(isSubtree(t11, t21));
    }
}
