/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 */

import java.util.HashSet;

/**
 * Definition for a binary tree node.
 */
public class SubtreeofAnotherTree {
    private class TreeNode {
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
    public String preorder(TreeNode t, boolean left) {
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }

    public boolean traverse(TreeNode s,TreeNode t)
    {
        return s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}
