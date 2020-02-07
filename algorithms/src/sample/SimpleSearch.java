package sample;

import common.Sample;

import java.util.*;

@Sample
public class SimpleSearch {
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String args[]) {

        /**
         *               7
         *          3       11
         *      -3    55   23   1
         *    0  8   5
         *
         *    dfs : 0, -3, 8, 3, 5, 55, 7, 23, 11, 1
         *    bfs : 7 3 11 -3 55 23 1 0 8 5
         */
        TreeNode root = new TreeNode(7);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(11);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(55);
        TreeNode t5 = new TreeNode(23);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(5);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t4.right = t8;
        t4.left = t9;

//        dfsTest(root);
        bfsTest(root);
    }

    public static void dfsTest(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        stack.push(root);

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + ", ");
            curr = curr.right;
        }
    }

    public static void bfsTest(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            TreeNode t = q.poll();

            if(t == null) continue;
            System.out.print(t.val + ", ");

            q.add(t.left);
            q.add(t.right);

        }
    }
}
