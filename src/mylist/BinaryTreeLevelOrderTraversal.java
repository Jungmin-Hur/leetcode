/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
package mylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        List<List<Integer>> res = levelOrder(t1);
        for(List<Integer> list : res) {
            list.stream().forEach(item -> System.out.print(item + " "));
            System.out.println("");
        }

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
